package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

//    @Bean
//    public CommandLineRunner demo(BuddyInfoRepository repository1, AddressBookRepository repository2) {
//        return (args) -> {
//            // creates some buddies and an address book first
//            BuddyInfo buddy1 = new BuddyInfo("Haman", "613-111-1112");
//            BuddyInfo buddy2 = new BuddyInfo("Char", "613-222-1122");
//            BuddyInfo buddy3 = new BuddyInfo("Amuro", "613-123-4567");
//            BuddyInfo buddy4 = new BuddyInfo("Noa", "613-333-4444");
//            BuddyInfo buddy5 = new BuddyInfo("Puru", "613-555-6666");
//            AddressBook addressBook = new AddressBook();
//
//            // add the buddies into addressbook
//            addressBook.addBuddy(buddy1);
//            addressBook.addBuddy(buddy2);
//            addressBook.addBuddy(buddy3);
//            addressBook.addBuddy(buddy4);
//            addressBook.addBuddy(buddy5);
//
//            // save in repos
//
////            repository1.save(buddy1);
////            repository1.save(buddy2);
////            repository1.save(buddy3);
////            repository1.save(buddy4);
////            repository1.save(buddy5);
//            repository2.save(addressBook);
//
//
//            // fetch all buddies
//            log.info("Buddy found with findAll():");
//            log.info("-------------------------------");
//            for (BuddyInfo buddy : repository1.findAll()) {
//                log.info(buddy.toString());
//            }
//            log.info("");
//
//            // fetch buddy by ID
//            BuddyInfo buddy6 = repository1.findById(1L);
//            log.info("Buddy found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(buddy6.toString());
//            log.info("");
//
//            // fetch buddy by phone number
//            BuddyInfo buddy7 = repository1.findByPhoneNum("613-111-1112");
//            log.info("Buddy found with findByPhoneNum(613-111-1112):");
//            log.info("--------------------------------");
//            log.info(buddy7.toString());
//            log.info("");
//
//
//            // fetch buddy by name
//            BuddyInfo buddy8 = repository1.findByName("Amuro");
//            log.info("Buddy found with findByName(Amuro):");
//            log.info("--------------------------------");
//            log.info(buddy8.toString());
//            log.info("");
//
//            // fetch the address book
//            log.info("Buddy found with findAll() in address book:");
//            log.info("-------------------------------");
//            for (AddressBook addressBook1 : repository2.findAll()) {
//                log.info(addressBook1.toString());
//            }
//            log.info("");
//        };
//    }
}
