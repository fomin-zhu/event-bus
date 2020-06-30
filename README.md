### 简介
主要实现事件通知（非跨服务通知），一种是基于订阅模式的领域事件通知，一种是基于guava的EventBus通知
### 使用
##### guava事件通知
- 定义事件通知模型
~~~
public class UserEvent extends BaseEvent {

    private User user;

    public UserEvent(User user) {
        this.user = user;
    }

    @Override
    protected String identify() {
        return "user-event";
    }
}
~~~
- 定义自己的事件发送者
~~~
@Component
public class UserPublisher extends GuavaEventPublisher {
    @Override
    public String identify() {
        return "user-event";
    }
}
~~~
- 定义事件接收者
~~~
@Component
public class UserListener {

    @Autowired
    public UserListener(UserPublisher usePublisher) {
        usePublisher.register(this);
    }

    @Subscribe
    public void listenUserRegisterEvent(UserEvent userEvent) {
        System.out.println(userEvent.getCurrentTime() + " welcome to join us!");
    }
}
~~~
- 使用
~~~
@Service
public class UserService {
    @Autowired
    private UserPublisher publisher;

    public void register(String name, Integer age) {
        publisher.publish(new UserEvent(new User(name, age)));
    }
}
~~~
#### 领域事件通知

- 定义领域实体
~~~
public class Product extends BaseEntity<Long, ProductRepository> {
    private String name;

    public Product(Long id, ProductRepository repo) {
        super(id, repo);
    }


    public void create(ProductEvent event) {
        // getRepo()
        System.out.println("create product.");
        publish(event);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
~~~
- 定义领域事件
~~~
public class ProductEvent implements DomainEvent {

    private Product product;

    public ProductEvent(Product product) {
        this.product = product;
    }

    @Override
    public Instant getCurrentTime() {
        return Instant.now();
    }

    public Product getProduct() {
        return product;
    }
}
~~~
- 定义领域消费者
~~~
@Component
public class ProductListener implements DomainEventSubscriber<ProductEvent> {

    @Override
    public void handle(ProductEvent event) {
        System.out.println("received order created event:{}." + event.getProduct().getName());
    }
}
~~~
- 定义领域工厂
~~~
@Component
public class Factory {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductListener productListener;

    public Product buildProduct(long id) {
        Product product = new Product(id, productRepository);
        product.subscribe(ProductEvent.class, productListener);
        return product;
    }
}
~~~
- 使用
~~~
@Component
public class ProductManager {
    @Autowired
    private Factory factory;
    @Autowired
    private ProductRepository repository;

    public void create(String name) {
        Product product = factory.buildProduct(repository.insert(name));
        product.setName(name);
        product.create(new ProductEvent(product));
    }
}
~~~
