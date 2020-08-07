package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;



    @Override
    public void run(String...strings){

        //USER ROLE
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setEnabled(true);

        Role userRole = new Role("user", "ROLE_USER");

        userRepository.save(user);
        roleRepository.save(userRole);

        //ADMIN ROLE
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEnabled(true);

        Role adminRole1 = new Role("admin", "ROLE_USER");
        Role adminRole2 = new Role("admin", "ROLE_ADMIN");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);

//        PRELOADING DATA

        Category fiction = new Category("Fiction");
        categoryRepository.save(fiction);

        Category nonFiction = new Category("Non-fiction");
        categoryRepository.save(nonFiction);

        Category bio = new Category("Biography");
        categoryRepository.save(bio);

        Category novel = new Category("Novel");
        categoryRepository.save(novel);

        Category youngAdult = new Category("Young Adult");
        categoryRepository.save(youngAdult);

        Category children = new Category("Children's Books");
        categoryRepository.save(children);

        Book book = new Book();
        book.setTitle("Clifford the Big Red Dog");
//        book.setCoverArt();
        book.setAuthor("Mary Elizabeth");
        book.setInStock(true);
        book.setISBN("9583720123");
        book.setQuantity(3);
        book.setYear(2000);
        book.setCategory(children);
        bookRepository.save(book);

        Book book2 = new Book();
        book2.setTitle("Arthur Goes to School");
//        book.setCoverArt();
        book2.setAuthor("Marc Brown");
        book2.setInStock(true);
        book2.setISBN("8473920471");
        book2.setQuantity(2);
        book2.setYear(1999);
        book2.setCategory(children);
        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setCategory(fiction);
        book3.setTitle("1984");
        book3.setCoverArt("https://prodimage.images-bn.com/pimages/9780451524935_p0_v5_s550x406.jpg");
        book3.setAuthor("George Orwell");
        book3.setInStock(true);
        book3.setISBN("9780451524935");
        book3.setQuantity(3);
        book3.setYear(1950);
        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setCategory(fiction);
        book4.setTitle("Little Fire's Everywhere");
        book4.setCoverArt("https://prodimage.images-bn.com/pimages/9780735224315_p0_v5_s550x406.jpg");
        book4.setAuthor("Celeste Ng");
        book4.setInStock(false);
        book4.setISBN("9780735224315");
        book4.setQuantity(0);
        book4.setYear(2019);
        bookRepository.save(book4);

        Book book5 = new Book();
        book5.setCategory(fiction);
        book5.setTitle("The Handmaid's Tale");
        book5.setCoverArt("https://prodimage.images-bn.com/pimages/9781984899668_p0_v1_s550x406.jpg");
        book5.setAuthor("Margaret Atwood");
        book5.setInStock(true);
        book5.setISBN("9781984899668");
        book5.setQuantity(1);
        book5.setYear(2019);
        bookRepository.save(book5);

        Book book6 = new Book();
        book6.setCategory(fiction);
        book6.setTitle("Fahrenheit 451 (Re-issue)");
        book6.setCoverArt("https://prodimage.images-bn.com/pimages/9781451673319_p0_v9_s550x406.jpg");
        book6.setAuthor("Ray Bradbury");
        book6.setInStock(true);
        book6.setISBN("9781984899668");
        book6.setQuantity(1);
        book6.setYear(2012);
        bookRepository.save(book6);


    }
}
