package ru.BaymuhanovN.telegrambot;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import ru.BaymuhanovN.telegrambot.entities.*;
import ru.BaymuhanovN.telegrambot.service.*;
import ru.BaymuhanovN.telegrambot.repositories.*;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FillingTests {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientOrderRepository clientOrderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ClientService clientService;
    @Test
    @Order(1)
    void createTwoClients() {
        Client client1 = new Client();
        client1.setAddress("Puskino");
        client1.setExternalId(1L);
        client1.setFullName("Ivanow");
        client1.setPhoneNumber("+79781234567");
        clientRepository.save(client1);
        Client client2 = new Client();
        client2.setAddress("Petrovska");
        client2.setExternalId(10L);
        client2.setFullName("Kulibin");
        client2.setPhoneNumber("+7934576834");
        clientRepository.save(client2);
    }

    @Test
    @Order(2)
    void createCategory() {
        Category mainCategory = new Category();
        mainCategory.setName("Main Category");
        categoryRepository.save(mainCategory);

        Category pizzaCategory = new Category();
        pizzaCategory.setName("Pizza");
        pizzaCategory.setParent(mainCategory);
        categoryRepository.save(pizzaCategory);

        Product margheritaPizza = new Product();
        margheritaPizza.setCategory(pizzaCategory);
        margheritaPizza.setName("Margherita Pizza");
        margheritaPizza.setDescription("Tomato sauce, mozzarella cheese, and fresh basil.");
        margheritaPizza.setPrice(600.0);
        productRepository.save(margheritaPizza);

        Product pepperoniPizza = new Product();
        pepperoniPizza.setCategory(pizzaCategory);
        pepperoniPizza.setName("Pepperoni Pizza");
        pepperoniPizza.setDescription("Tomato sauce, mozzarella cheese, and pepperoni.");
        pepperoniPizza.setPrice(700.0);
        productRepository.save(pepperoniPizza);

        Product hawaiianPizza = new Product();
        hawaiianPizza.setCategory(pizzaCategory);
        hawaiianPizza.setName("Hawaiian Pizza");
        hawaiianPizza.setDescription("Tomato sauce, mozzarella cheese, ham, and pineapple.");
        hawaiianPizza.setPrice(800.0);
        productRepository.save(hawaiianPizza);

        Category rollsCategory = new Category();
        rollsCategory.setName("Rolls");
        rollsCategory.setParent(mainCategory);
        categoryRepository.save(rollsCategory);

        Category classicRollsSubcategory = new Category();
        classicRollsSubcategory.setName("Classic rolls");
        classicRollsSubcategory.setParent(rollsCategory);
        categoryRepository.save(classicRollsSubcategory);

        Product californiaRoll = new Product();
        californiaRoll.setCategory(classicRollsSubcategory);
        californiaRoll.setName("California Roll");
        californiaRoll.setDescription("crab, avocado, and cucumber roll, topped with tobiko");
        californiaRoll.setPrice(250.0);
        productRepository.save(californiaRoll);

        Product philadelphiaRoll = new Product();
        philadelphiaRoll.setCategory(classicRollsSubcategory);
        philadelphiaRoll.setName("Philadelphia Roll");
        philadelphiaRoll.setDescription("salmon, cream cheese, and cucumber roll. Price");
        philadelphiaRoll.setPrice(300.0);
        productRepository.save(philadelphiaRoll);

        Product spicyTunaRoll = new Product();
        spicyTunaRoll.setCategory(classicRollsSubcategory);
        spicyTunaRoll.setName("Spicy TunaRoll");
        spicyTunaRoll.setDescription("tuna, spicy mayo, and cucumber roll");
        spicyTunaRoll.setPrice(350.0);
        productRepository.save(spicyTunaRoll);


        Category bakedRollsSubcategory = new Category();
        bakedRollsSubcategory.setName("Baked rolls");
        bakedRollsSubcategory.setParent(rollsCategory);
        categoryRepository.save(bakedRollsSubcategory);

        Product dragonRoll = new Product();
        dragonRoll.setCategory(bakedRollsSubcategory);
        dragonRoll.setName("Dragon Roll");
        dragonRoll.setDescription("shrimp tempura and cucumber roll, topped with avocado and eel sauce");
        dragonRoll.setPrice(400.0);
        productRepository.save(dragonRoll);

        Product volcanoRoll = new Product();
        volcanoRoll.setCategory(classicRollsSubcategory);
        volcanoRoll.setName("Volcano Roll");
        volcanoRoll.setDescription("crab, avocado, and cucumber roll, topped with spicy tuna and tempura flakes");
        volcanoRoll.setPrice(450.0);
        productRepository.save(volcanoRoll);

        Product caterpillarRoll = new Product();
        caterpillarRoll.setCategory(classicRollsSubcategory);
        caterpillarRoll.setName("Caterpillar Roll");
        caterpillarRoll.setDescription("eel and cucumber roll, topped with avocado and eel sauce");
        caterpillarRoll.setPrice(500.0);
        productRepository.save(caterpillarRoll);

        Category sweetSollsSubcategory = new Category();
        sweetSollsSubcategory.setName("Sweet rolls");
        sweetSollsSubcategory.setParent(rollsCategory);
        categoryRepository.save(sweetSollsSubcategory);

        Product mangoRoll = new Product();
        mangoRoll.setCategory(sweetSollsSubcategory);
        mangoRoll.setName("Mango Roll");
        mangoRoll.setDescription("Mango, cream cheese, and crab roll.");
        mangoRoll.setPrice(250.0);
        productRepository.save(mangoRoll);

        Product bananaNutellaRoll = new Product();
        bananaNutellaRoll.setCategory(sweetSollsSubcategory);
        bananaNutellaRoll.setName("Banana Nutella Roll");
        bananaNutellaRoll.setDescription("Banana and Nutella roll, topped with chocolate sauce.");
        bananaNutellaRoll.setPrice(300.0);
        productRepository.save(bananaNutellaRoll);

        Product strawberryCheesecakeRoll = new Product();
        strawberryCheesecakeRoll.setCategory(sweetSollsSubcategory);
        strawberryCheesecakeRoll.setName("Strawberry Cheesecake Roll");
        strawberryCheesecakeRoll.setDescription("Strawberry, cream cheese, and graham cracker roll.");
        strawberryCheesecakeRoll.setPrice(350.0);
        productRepository.save(strawberryCheesecakeRoll);


        Category setSubcategory = new Category();
        setSubcategory.setName("Sets");
        setSubcategory.setParent(rollsCategory);
        categoryRepository.save(setSubcategory);

        Product sushiSetA = new Product();
        sushiSetA.setCategory(setSubcategory);
        sushiSetA.setName("Sushi Set A");
        sushiSetA.setDescription("6 pieces of nigiri and 8 pieces of California roll.");
        sushiSetA.setPrice(800.0);
        productRepository.save(sushiSetA);

        Product sushiSetB = new Product();
        sushiSetB.setCategory(setSubcategory);
        sushiSetB.setName("Sushi Set B");
        sushiSetB.setDescription("10 pieces of sashimi and 8 pieces of spicy tuna roll.");
        sushiSetB.setPrice(900.0);
        productRepository.save(sushiSetB);

        Product sushiSetC = new Product();
        sushiSetC.setCategory(setSubcategory);
        sushiSetC.setName("Sushi Set C");
        sushiSetC.setDescription("5 pieces of nigiri, 5 pieces of sashimi, and 8 pieces of dragon roll.");
        sushiSetC.setPrice(1000.0);
        productRepository.save(sushiSetC);

        Category burgersCategory = new Category();
        burgersCategory.setName("Burgers");
        burgersCategory.setParent(mainCategory);
        categoryRepository.save(burgersCategory);

        Category classicBurgersSubcategory = new Category();
        classicBurgersSubcategory.setName("Classic burgers");
        classicBurgersSubcategory.setParent(burgersCategory);
        categoryRepository.save(classicBurgersSubcategory);

        Product cheeseburger = new Product();
        cheeseburger.setCategory(classicBurgersSubcategory);
        cheeseburger.setName("Cheeseburger");
        cheeseburger.setDescription("Beef patty with cheddar cheese, lettuce, tomato, onion, and pickles on a sesame seed bun.");
        cheeseburger.setPrice(350.0);
        productRepository.save(cheeseburger);

        Product baconCheeseburger = new Product();
        baconCheeseburger.setCategory(classicBurgersSubcategory);
        baconCheeseburger.setName("Bacon Cheeseburger");
        baconCheeseburger.setDescription("Beef patty with bacon, cheddar cheese, lettuce, tomato, onion, and pickles on a sesame seed bun.");
        baconCheeseburger.setPrice(400.0);
        productRepository.save(baconCheeseburger);

        Product mushroomSwissBurger = new Product();
        mushroomSwissBurger.setCategory(classicBurgersSubcategory);
        mushroomSwissBurger.setName("Mushroom Swiss Burger");
        mushroomSwissBurger.setDescription("Beef patty with sautéed mushrooms, Swiss cheese, lettuce, tomato, onion, and pickles on a sesame seed bun.");
        mushroomSwissBurger.setPrice(450.0);
        productRepository.save(mushroomSwissBurger);

        Category spicyBurgersSubcategory = new Category();
        spicyBurgersSubcategory.setName("Spicy burgers");
        spicyBurgersSubcategory.setParent(burgersCategory);
        categoryRepository.save(spicyBurgersSubcategory);

        Product jalapenoBurger = new Product();
        jalapenoBurger.setCategory(spicyBurgersSubcategory);
        jalapenoBurger.setName("Jalapeño Burger");
        jalapenoBurger.setDescription("Beef patty with jalapeños, pepper jack cheese, lettuce, tomato, onion, and pickles on a sesame seed bun.");
        jalapenoBurger.setPrice(350.0);
        productRepository.save(jalapenoBurger);

        Product chipotleBurger = new Product();
        chipotleBurger.setCategory(spicyBurgersSubcategory);
        chipotleBurger.setName("Chipotle Burger");
        chipotleBurger.setDescription("Beef patty with chipotle mayo, pepper jack cheese, lettuce, tomato, onion, and pickles on a sesame seed bun.");
        chipotleBurger.setPrice(400.0);
        productRepository.save(chipotleBurger);

        Product habaneroBurger = new Product();
        habaneroBurger.setCategory(spicyBurgersSubcategory);
        habaneroBurger.setName("Habanero Burger");
        habaneroBurger.setDescription("Beef patty with habanero sauce, pepper jack cheese, lettuce, tomato, onion, and pickles on a sesame seed bun.");
        habaneroBurger.setPrice(450.0);
        productRepository.save(habaneroBurger);

        Category beveragesCategory = new Category();
        beveragesCategory.setName("Beverages");
        beveragesCategory.setParent(mainCategory);
        categoryRepository.save(beveragesCategory);

        Category carbonatedDrinksSubcategory = new Category();
        carbonatedDrinksSubcategory.setName("Carbonated drinks");
        carbonatedDrinksSubcategory.setParent(beveragesCategory);
        categoryRepository.save(carbonatedDrinksSubcategory);

        Product cocaCola = new Product();
        cocaCola.setCategory(carbonatedDrinksSubcategory);
        cocaCola.setName("Coca-Cola");
        cocaCola.setDescription("Classic cola flavor.");
        cocaCola.setPrice(50.0);
        productRepository.save(cocaCola);

        Product sprite = new Product();
        sprite.setCategory(carbonatedDrinksSubcategory);
        sprite.setName("Sprite");
        sprite.setDescription("Lemon-lime flavor.");
        sprite.setPrice(50.0);
        productRepository.save(sprite);

        Product fanta = new Product();
        fanta.setCategory(carbonatedDrinksSubcategory);
        fanta.setName("Fanta");
        fanta.setDescription("Orange flavor.");
        fanta.setPrice(50.0);
        productRepository.save(fanta);

        Category energyDrinksSubcategory = new Category();
        energyDrinksSubcategory.setName("Energy drinks");
        energyDrinksSubcategory.setParent(beveragesCategory);
        categoryRepository.save(energyDrinksSubcategory);

        Product redBull = new Product();
        redBull.setCategory(energyDrinksSubcategory);
        redBull.setName("Red Bull");
        redBull.setDescription("Classic energy drink with a sweet, fruity flavor.");
        redBull.setPrice(150.0);
        productRepository.save(redBull);

        Product monster = new Product();
        monster.setCategory(energyDrinksSubcategory);
        monster.setName("Monster");
        monster.setDescription("Energy drink with a sweet, citrus flavor.");
        monster.setPrice(150.0);
        productRepository.save(monster);

        Product rockstar = new Product();
        rockstar.setCategory(energyDrinksSubcategory);
        rockstar.setName("Rockstar");
        rockstar.setDescription("Energy drink with a sweet, tropical flavor.");
        rockstar.setPrice(150.0);
        productRepository.save(rockstar);

        Category juicesSubcategory = new Category();
        juicesSubcategory.setName("Juices");
        juicesSubcategory.setParent(beveragesCategory);
        categoryRepository.save(juicesSubcategory);

        Product orangeJuice = new Product();
        orangeJuice.setCategory(juicesSubcategory);
        orangeJuice.setName("Orange Juice");
        orangeJuice.setDescription("Freshly squeezed orange juice.");
        orangeJuice.setPrice(100.0);
        productRepository.save(orangeJuice);

        Product appleJuice = new Product();
        appleJuice.setCategory(juicesSubcategory);
        appleJuice.setName("Apple Juice");
        appleJuice.setDescription("Freshly squeezed apple juice.");
        appleJuice.setPrice(100.0);
        productRepository.save(appleJuice);

        Product carrotJuice = new Product();
        carrotJuice.setCategory(juicesSubcategory);
        carrotJuice.setName("Carrot Juice");
        carrotJuice.setDescription("Freshly squeezed carrot juice.");
        carrotJuice.setPrice(100.0);
        productRepository.save(carrotJuice);

        Category otherDrinksSubcategory = new Category();
        otherDrinksSubcategory.setName("Other drinks");
        otherDrinksSubcategory.setParent(beveragesCategory);
        categoryRepository.save(otherDrinksSubcategory);

        Product icedTea = new Product();
        icedTea.setCategory(otherDrinksSubcategory);
        icedTea.setName("Iced Tea");
        icedTea.setDescription("Freshly brewed black tea, served over ice.");
        icedTea.setPrice(75.0);
        productRepository.save(icedTea);

        Product lemonade = new Product();
        lemonade.setCategory(otherDrinksSubcategory);
        lemonade.setName("Lemonade");
        lemonade.setDescription("Freshly squeezed lemon juice, mixed with sugar and water.");
        lemonade.setPrice(75.0);
        productRepository.save(lemonade);

        Product milkshake = new Product();
        milkshake.setCategory(otherDrinksSubcategory);
        milkshake.setName("Milkshake");
        milkshake.setDescription("Vanilla ice cream, blended with milk and your choice of flavor (chocolate, strawberry, etc.).");
        milkshake.setPrice(150.0);
        productRepository.save(milkshake);
    }

    @Test
    @Order(3)
    void createClientOrders() {
        Client client1 = clientService.getClientByExternalId(1L);
        Client client2 = clientService.getClientByExternalId(2L);

        for (int i = 0; i < 10; i++) {
            ClientOrder order = new ClientOrder();
            order.setClient(i % 2 == 0 ? client1 : client2);
            order.setStatus(0);
            order.setTotal(100.0 + i);
            clientOrderRepository.save(order);

        }
    }

    @Test
    @Order(3)
    public void createOrderProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<ClientOrder> orders = (List<ClientOrder>) clientOrderRepository.findAll();

        for (int i = 0; i < 10; i++) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setClientOrder(orders.get(i));
            orderProduct.setProduct(products.get(i % products.size()));
            orderProduct.setCountProduct((long) (i + 1));
            orderProductRepository.save(orderProduct);
        }
    }
}