package com.simplug.data.dao;

import com.simplug.data.entity.PlayerData;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PlayerDataDao {

    private final SessionFactory sessionFactory;

    public Optional<PlayerData> findByPlayerName(String playerName) {
        return (Optional<PlayerData>) sessionFactory.openSession()
                .createQuery("from PlayerData where playerName=:playerName")
                .setParameter("playerName", playerName)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    public PlayerData findById(int id) {
        return sessionFactory.openSession().get(PlayerData.class, id);
    }

    public void save(PlayerData playerData) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(playerData);
        transaction.commit();
        session.close();
    }

    public void update(PlayerData playerData) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(playerData);
        transaction.commit();
        session.close();
    }

    public void delete(PlayerData playerData) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(playerData);
        transaction.commit();
        session.close();
    }

    public List<PlayerData> findAll() {
        List<PlayerData> playerDataList = (List<PlayerData>) sessionFactory.openSession().createQuery("From PlayerData").list();
        return playerDataList;
    }
}
