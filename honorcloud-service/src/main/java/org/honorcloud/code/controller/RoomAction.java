package org.honorcloud.code.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.honorcloud.code.controller.base.BaseControFunc;
import org.honorcloud.code.controller.base.BaseController;
import org.honorcloud.code.service.RoomService;
import org.honorcloud.common.constant.PageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sumoon
 * @since 2020-03-09
 */
@Controller
@RequestMapping("/room")
public class RoomAction extends BaseController implements BaseControFunc{
	
	@Autowired
	private RoomService roomService;
	
	@Override
	@RequestMapping("/index")
	public String index() {
		return PageConstant.PLAYER_INDEX;
	}

	@Override
	public boolean save(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upload(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dowmload(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object search(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean compare(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

}

