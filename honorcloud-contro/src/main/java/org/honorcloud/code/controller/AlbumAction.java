package org.honorcloud.code.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.honorcloud.code.controller.base.BaseControFunc;
import org.honorcloud.code.controller.base.BaseController;
import org.honorcloud.code.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumAction extends BaseController implements BaseControFunc{
	
	@Autowired
	private AlbumService albumService;
	
	@Override
	@RequestMapping("/index")
	public String index() {
		return PageConstant.ALBUM_INDEX;
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return PageConstant.ALBUM_ADMIN;
	}

	@Override
	public boolean save(Object object) {
		return false;
	}
	/**
	 * 图片上传
	 */
	@Override
	public boolean upload(Object object) {
		return false;
	}
	
	@Override
	public Object search(Object object) {
		return null;
	}
	
	@Override
	public boolean delete(Object object) {
		return false;
	}
	

	@Override
	public boolean dowmload(Object object) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean compare(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}

