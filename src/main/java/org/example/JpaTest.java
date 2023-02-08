//package org.example;
//
//import javax.persistence.*;
//import java.util.List;
//
//public class JpaTest {
//
//        public static void main(String[] args) {
//            performJPATest();
//        }
//
//        public static void performJPATest() {
//            //create some buddy infos
//            BuddyInfo buddyInfo1 = new BuddyInfo();
//            buddyInfo1.setName("Andy");
//            buddyInfo1.setPhoneNum("613-111-2222");
//
//            BuddyInfo buddyInfo2 = new BuddyInfo();
//            buddyInfo2.setName("Bill");
//            buddyInfo2.setPhoneNum("613-333-4444");
//
//            BuddyInfo buddyInfo3 = new BuddyInfo();
//            buddyInfo3.setName("Cole");
//            buddyInfo3.setPhoneNum("613-555-6666");
//
//            //create address book and add some buddy infos to it
//            AddressBook addressBook = new AddressBook();
//            addressBook.addBuddy(buddyInfo1);
//            addressBook.addBuddy(buddyInfo2);
//            addressBook.addBuddy(buddyInfo3);
//
//            //create emf
//            //create em
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("address-book-jpa-test");
//            EntityManager em = emf.createEntityManager();
//
//            //create transaction
//            EntityTransaction eTransact = em.getTransaction();
//            //persist buddy infos
//            eTransact.begin();
//            em.persist(buddyInfo1);
//            em.persist(buddyInfo2);
//            em.persist(buddyInfo3);
//            //persist address book
//            em.persist(addressBook);
//            //commit transaction
//            eTransact.commit();
//
//            //query
//            Query q = em.createQuery("SELECT buddyInfo FROM BuddyInfo buddyInfo");
//            List<BuddyInfo> result = q.getResultList();
//            System.out.println("List of BUddies\n-------------");
//            for (BuddyInfo b : result) {
//                System.out.println("buddy number " + b.getId() + ", " + b.getName() + " with phone number: " + b.getPhoneNum());
//            }
//
//            Query q2 = em.createQuery("SELECT addressBook FROM AddressBook addressBook");
//            List<AddressBook> result2 = q2.getResultList();
//            for (AddressBook addressBook1 : result2) {
//                System.out.println(addressBook1.getBuddies().toString());
//            }
//
//            //closing em
//            em.close();
//            //closing emf
//            emf.close();
//        }
//
//    }
