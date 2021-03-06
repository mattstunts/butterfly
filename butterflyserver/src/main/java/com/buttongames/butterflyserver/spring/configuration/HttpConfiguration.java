package com.buttongames.butterflyserver.spring.configuration;

import com.buttongames.butterflydao.hibernate.dao.impl.ButterflyUserDao;
import com.buttongames.butterflydao.hibernate.dao.impl.CardDao;
import com.buttongames.butterflydao.hibernate.dao.impl.ddr16.GameplayEventLogDao;
import com.buttongames.butterflydao.hibernate.dao.impl.ddr16.GhostDataDao;
import com.buttongames.butterflydao.hibernate.dao.impl.ddr16.PcbEventLogDao;
import com.buttongames.butterflydao.hibernate.dao.impl.ddr16.ProfileDao;
import com.buttongames.butterflydao.hibernate.dao.impl.ddr16.ShopDao;
import com.buttongames.butterflydao.hibernate.dao.impl.MachineDao;
import com.buttongames.butterflydao.hibernate.dao.impl.UserPhasesDao;
import com.buttongames.butterflydao.hibernate.dao.impl.ddr16.UserSongRecordDao;
import com.buttongames.butterflyserver.http.ButterflyHttpServer;
import com.buttongames.butterflyserver.http.handlers.impl.CardManageRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.EacoinRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.EventLogRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.FacilityRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.MessageRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.PackageRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.PcbEventRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.PcbTrackerRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.PlayerDataRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.ServicesRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.SystemRequestHandler;
import com.buttongames.butterflyserver.http.handlers.impl.TaxRequestHandler;
import com.buttongames.butterflycore.util.CardIdUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Bean config class for <code>com.buttongames.butterflyserver.http</code> package.
 * @author skogaby (skogabyskogaby@gmail.com)
 */
@Configuration
@ComponentScan({"com.buttongames.butterflyserver.spring.configuration",
                "com.buttongames.butterflydao.spring.configuration"})
@PropertySource("classpath:butterflyserver.properties")
public class HttpConfiguration {

    @Bean
    public ButterflyHttpServer butterflyHttpServer(final ServicesRequestHandler servicesRequestHandler,
                                                   final PcbEventRequestHandler pcbEventRequestHandler,
                                                   final PcbTrackerRequestHandler pcbTrackerRequestHandler,
                                                   final MessageRequestHandler messageRequestHandler,
                                                   final FacilityRequestHandler facilityRequestHandler,
                                                   final PackageRequestHandler packageRequestHandler,
                                                   final EventLogRequestHandler eventLogRequestHandler,
                                                   final TaxRequestHandler taxRequestHandler,
                                                   final PlayerDataRequestHandler playerDataRequestHandler,
                                                   final CardManageRequestHandler cardManageRequestHandler,
                                                   final SystemRequestHandler systemRequestHandler,
                                                   final EacoinRequestHandler eacoinRequestHandler,
                                                   final MachineDao machineDao,
                                                   final ButterflyUserDao userDao) {
        return new ButterflyHttpServer(servicesRequestHandler, pcbEventRequestHandler, pcbTrackerRequestHandler,
                messageRequestHandler, facilityRequestHandler, packageRequestHandler, eventLogRequestHandler,
                taxRequestHandler, playerDataRequestHandler, cardManageRequestHandler, systemRequestHandler,
                eacoinRequestHandler, machineDao, userDao);
    }

    @Bean
    public CardIdUtils cardIdUtils() {
        return new CardIdUtils();
    }

    @Bean
    public EventLogRequestHandler eventLogRequestHandler(final GameplayEventLogDao gameplayEventLogDao) {
        return new EventLogRequestHandler(gameplayEventLogDao);
    }

    @Bean
    public FacilityRequestHandler facilityRequestHandler(final ShopDao shopDao, final MachineDao machineDao) {
        return new FacilityRequestHandler(shopDao, machineDao);
    }

    @Bean
    public MessageRequestHandler messageRequestHandler() {
        return new MessageRequestHandler();
    }

    @Bean
    public PackageRequestHandler packageRequestHandler() {
        return new PackageRequestHandler();
    }

    @Bean
    public PcbEventRequestHandler pcbEventRequestHandler(final PcbEventLogDao pcbEventLogDao) {
        return new PcbEventRequestHandler(pcbEventLogDao);
    }

    @Bean
    public PcbTrackerRequestHandler pcbTrackerRequestHandler() {
        return new PcbTrackerRequestHandler();
    }

    @Bean
    public ServicesRequestHandler servicesRequestHandler() {
        return new ServicesRequestHandler();
    }

    @Bean
    public PlayerDataRequestHandler playerDataRequestHandler(final ButterflyUserDao userDao, final CardDao cardDao,
                                                             final ProfileDao profileDao, final GhostDataDao ghostDataDao,
                                                             final UserSongRecordDao songRecordDao) {
        return new PlayerDataRequestHandler(userDao, cardDao, profileDao, ghostDataDao, songRecordDao);
    }

    @Bean
    public TaxRequestHandler taxRequestHandler(final MachineDao machineDao, final UserPhasesDao userPhasesDao) {
        return new TaxRequestHandler(machineDao, userPhasesDao);
    }

    @Bean
    public CardManageRequestHandler cardManageRequestHandler(final CardDao cardDao, final ButterflyUserDao userDao,
                                                             final CardIdUtils cardIdUtils) {
        return new CardManageRequestHandler(cardDao, userDao, cardIdUtils);
    }

    @Bean
    public SystemRequestHandler systemRequestHandler(final CardIdUtils cardIdUtils) {
        return new SystemRequestHandler(cardIdUtils);
    }

    @Bean
    public EacoinRequestHandler eacoinRequestHandler(final CardDao cardDao) {
        return new EacoinRequestHandler(cardDao);
    }
}
