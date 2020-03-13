package org.honorcloud.code.service.impl;

import org.honorcloud.code.dao.PlayerDao;
import org.honorcloud.code.entity.Player;
import org.honorcloud.code.service.PlayerService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sumoon
 * @since 2020-03-09
 */
@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerDao, Player> implements PlayerService {

}
