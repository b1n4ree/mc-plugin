package com.simplug.data.dao;

import com.simplug.data.entity.PlayerData;
import lombok.RequiredArgsConstructor;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@RequiredArgsConstructor
public class PlayerDataDao {

    private final SessionFactory sessionFactory;

    public PlayerData findOrCreateByPlayerName(String playerName) {
        PlayerData playerData =  sessionFactory
                .openSession()
                .get(PlayerData.class, playerName);

        if (playerData != null) {
            return playerData;
        }

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new PlayerData(playerName, 0L, "default", 0L, 0L, 0L));
        playerData = session.get(PlayerData.class, playerName);

        transaction.commit();
        session.close();

        return playerData;
    }

    public PlayerData update(PlayerData playerData) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        PlayerData updatedPlayerData = session.merge(playerData);

        transaction.commit();
        session.close();

        return updatedPlayerData;
    }

    public void updateAll(List<PlayerData> playerDataList) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.setCacheMode(CacheMode.IGNORE);
        final int batchSize = 15;

        for (int index = 0; index < playerDataList.size(); index++) {
            if (index > 0 && index % batchSize == 0) {
                //flush a batch of inserts and release memory
                session.flush();
                session.clear();
            }

            session.merge(playerDataList.get(index));
        }

        transaction.commit();
        session.close();
    }
}
