package weixin.material;

public class MaterialTester {

	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  0.0.1
	 */
	public static void main(String[] args) {

		
		//1、获取accesstoken
//		AccessTokenManager  atm  = new AccessTokenManager();
//		AccessTokenManager.accesstoken = "Ee2jCrzRQ1yqbs8Ibb4F_-OW5kXO9scYrWXQtCwk6Zd9uNKfLTIGSj3wZm_Re8cHs4sLga3snqy9lVhClgAFk1L-wc0GED4RjOFDfZkwY7KU27yJGbiuN5VD-Itz93ZpGAIcAHABVD";
			
		//2、测试新增永久图文素材
//		MaterialManager mm = new MaterialManager();
//		List<Article> list = new ArrayList<Article>();
//		//单图文
//		Article article = new Article();
//		article.setTitle("test");
//		article.setThumb_media_id("DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg");
//		article.setAuthor("tt");
//		article.setDigest("this is digest");
//		article.setShow_cover_pic("1");
//		article.setContent("test1\ntest2\ntest3\nyou are beautiful");
//		article.setContent_source_url("http://www.ipaiban.com");
//		list.add(article);
//		//多图文
//		article = new Article();
//		article.setTitle("testtest");
//		article.setThumb_media_id("DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg");
//		article.setAuthor("tt2");
//		article.setDigest("this is another digest");
//		article.setShow_cover_pic("1");
//		article.setContent("test1\ntest2\ntest3\nyou are handsome");
//		article.setContent_source_url("http://www.ipaiban.com");
//		list.add(article);
//		
//		String mediaId = mm.addNews(list);
//		System.out.println("----------add news----------");
//		System.out.println(mediaId);
		
		//3、测试上传图文消息里的图片获取URL
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		String imgurl = mm.uploadImg(filePath);
//		System.out.println("----------get image url----------");
//		System.out.println(imgurl);
		
		//4-1、上传永久图片素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		String type = "image";
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, null);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload image----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//4-2、上传永久语音素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\1351.amr";
//		String type = "voice";
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, null);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload voice----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//4-3、上传永久视频素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\coin_RPCA.mp4";
//		String type = "video";
//		HashMap<String, String> description = new HashMap<String, String>();
//		description.put("title","coin");
//		description.put("introduction","video test");
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, description);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload video----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//4-4、上传永久缩略图素材
//		MaterialManager mm = new MaterialManager();
//		String filePath = "D:\\XHR\\ScanLogin\\uploadTest\\wukonglai.jpg";
//		String type = "thumb";
//		HashMap<String, String> hm = mm.addMaterial(filePath, type, null);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------upload thumb----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//5、测试获取永久图文素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5372hZWypUwL_BF-kseJoIs";//单图文
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5x5hXParS-R8oBm1KcKERxw";//多图文
//		List<Article> list = mm.getMaterial_article(mediaId);
//		System.out.println("----------get articles----------");
//		for(int i=0;i<list.size();i++){
//			Article article = list.get(i);
//			System.out.println("------#"+i+"------");
//			System.out.println("title: "+article.getTitle());
//			System.out.println("thumb_media_id: "+article.getThumb_media_id());
//			System.out.println("show_cover_pic: "+article.getShow_cover_pic());
//			System.out.println("author: "+article.getAuthor());
//			System.out.println("digest: "+article.getDigest());
//			System.out.println("content: "+article.getContent());
//			System.out.println("url: "+article.getUrl());
//			System.out.println("content_source_url: "+article.getContent_source_url());
//		}
		
		//6、测试获取永久视频素材URL
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5yHEJyEXUiAwX2Q0pwVWvtI";
//		HashMap<String, String> hm = mm.getMaterial_videoUrl(mediaId);
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------get video url----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//7-1、测试获取永久图片素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo53LkY8Jljwh965FFoE1ebyY";
//		String filePath = "D:\\";
//		String fileName = "test.jpg";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get image----------");
//		System.out.println(success);
		
		//7-2、测试获取永久语音素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo55dMqa3pzt8IQybeuGIMnK8";
//		String filePath = "D:\\";
//		String fileName = "test.amr";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get voice----------");
//		System.out.println(success);
		
		//7-3、测试获取永久视频素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5yHEJyEXUiAwX2Q0pwVWvtI";
//		String filePath = "D:\\";
//		String fileName = "test.mp4";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get video----------");
//		System.out.println(success);
		
		//7-4、测试获取永久缩略图素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg";
//		String filePath = "D:\\";
//		String fileName = "test2.jpg";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get thumb----------");
//		System.out.println(success);
		
		//7-5、测试获取永久缩略图素材失败
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg";
//		String filePath = "D:\\";
//		String fileName = "test2.jpg";
//		boolean success = mm.downMaterial(mediaId, filePath, fileName);
//		System.out.println("----------get thumb----------");
//		System.out.println(success);
		
		//8、测试删除素材
//		MaterialManager mm = new MaterialManager();
//		String mediaId = "DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg";
//		boolean success = mm.deleteMaterial(mediaId);
//		System.out.println("----------delete material----------");
//		System.out.println(success);
		
		//9、测试修改永久图文素材
//		MaterialManager mm = new MaterialManager();
//		Article article = new Article();
//		article.setTitle("testupdate");
//		article.setThumb_media_id("DNkPiq_x1JFtepHpgHXo59cGUTU749G5cnBcjtBcFRg");
//		article.setAuthor("ss");
//		article.setDigest("this is another digest");
//		article.setShow_cover_pic("");
//		article.setContent("test1\ntest2\ntest3\nyou are handsome!");
//		article.setContent_source_url("http://www.ipaiban.com");
//		String mediaId = "DNkPiq_x1JFtepHpgHXo5x5hXParS-R8oBm1KcKERxw";
//		int index = 1;
//		boolean success = mm.updateNews(mediaId, index, article);
//		System.out.println("----------update news----------");
//		System.out.println(success);
		
		//10、测试获取永久素材总数
//		MaterialManager mm = new MaterialManager();
//		HashMap<String, Integer> hm = mm.getMaterialCount();
//		Object[] keys = hm.keySet().toArray();
//		System.out.println("----------get material count----------");
//		for(int i=0;i<keys.length;i++){
//			System.out.println(keys[i]+": "+hm.get(keys[i]));
//		}
		
		//11、测试获取永久素材列表
//		MaterialManager mm = new MaterialManager();
//		String type = "image";
//		String type = "voice";
//		String type = "video";
//		String type = "news";
//		int offset = 2;
//		int count = 2;
//		List<HashMap> list = mm.getMaterilaList(type, offset, count);
//		System.out.println("----------get material list----------");
//		//非图文
//		for(int i=0;i<list.size();i++){
//			Object[] keys = list.get(i).keySet().toArray();
//			System.out.println("------#"+i+"------");
//			for(int j=0;j<keys.length;j++){
//				System.out.println(keys[j]+": "+list.get(i).get(keys[j]));
//			}
//		}
//		//图文
//		for(int i=0;i<list.size();i++){
//			System.out.println("------#"+i+"------");
//			List<Article> artlist = (List<Article>) list.get(i).get("content");
//			for(int j=0;j<artlist.size();j++){
//				Article article = artlist.get(j);
//				System.out.println("------#"+j+"#------");
//				System.out.println("title: "+article.getTitle());
//				System.out.println("thumb_media_id: "+article.getThumb_media_id());
//				System.out.println("show_cover_pic: "+article.getShow_cover_pic());
//				System.out.println("author: "+article.getAuthor());
//				System.out.println("digest: "+article.getDigest());
//				System.out.println("content: "+article.getContent());
//				System.out.println("url: "+article.getUrl());
//				System.out.println("content_source_url: "+article.getContent_source_url());
//			}
//		}

	}
}
