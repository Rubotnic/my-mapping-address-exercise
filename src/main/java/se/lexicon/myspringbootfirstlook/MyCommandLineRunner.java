package se.lexicon.myspringbootfirstlook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import se.lexicon.myspringbootfirstlook.dao.AppUserDao;
import se.lexicon.myspringbootfirstlook.model.Address;
import se.lexicon.myspringbootfirstlook.model.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Profile(value = "dev")
@Transactional
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(AppUserDao appUserDao, EntityManager entityManager){
        this.appUserDao = appUserDao;
        this.entityManager = entityManager;
    }

    private final AppUserDao appUserDao;
    private final EntityManager entityManager;


    @Override
    public void run(String... args) throws Exception {

    }
}
