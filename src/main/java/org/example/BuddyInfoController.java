package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuddyInfoController {
    private BuddyInfoRepository buddyInfoRepository;
    private AddressBookRepository addressBookRepository;
    @Autowired
    public BuddyInfoController(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }
    @RequestMapping(value = "/buddy", method = RequestMethod.GET)
    public BuddyInfo getBuddy(@RequestParam("bookId") Long id, @RequestParam("buddyId") Integer buddyId) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        return addressBook.getBuddy(buddyId-1);
    }
    @RequestMapping(value = "/buddy", method = RequestMethod.DELETE)
    public BuddyInfo removeBuddy(@RequestParam("bookId") Long id, @RequestParam("buddyId") Integer buddyId) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        BuddyInfo buddyInfo = addressBook.getBuddy(buddyId-1);
        addressBook.removeBuddy(buddyId-1);
        addressBookRepository.save(addressBook);
        buddyInfoRepository.delete(buddyInfo);
        return buddyInfo;
    }
    @RequestMapping(value = "/buddy", method = RequestMethod.POST)
    public BuddyInfo addBuddy(@RequestParam BuddyInfo buddyInfo, @RequestParam("bookId") Long id) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        addressBook.addBuddy(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);
        return buddyInfo;
    }
}
