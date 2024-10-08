package com.RegistrationAppBackend.jpa;

import com.RegistrationAppBackend.dao.ContactDao;
import com.RegistrationAppBackend.model.Contact;
import com.RegistrationAppBackend.repository.ContactRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jpa2")
public class ContactJPADataAcessService implements ContactDao {
    ContactRepository contactRepository;

    public ContactJPADataAcessService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Optional<Contact> getContactById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> SelectAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void InsertContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void DeleteContactById(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public boolean ExistContactByEmail(String email) {
        return contactRepository.existsByEmail(email);
    }
}
