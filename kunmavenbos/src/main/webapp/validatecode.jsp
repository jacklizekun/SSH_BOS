<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.awt.Color"%>
<%@ page import="java.awt.Font"%>
<%@ page import="java.awt.Graphics"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>
<%
	//宽度80px
	int width = 80;
	//高度32px
	int height = 32;
	//创建图片
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	//对图片进行绘画
	Graphics g = image.getGraphics();
	// 设置背景颜色
	g.setColor(new Color(0xDCDCDC));
	//填充
	g.fillRect(0, 0, width, height);
	g.setColor(Color.black);
	g.drawRect(0, 0, width - 1, height - 1);
	//随机数
	Random rdm = new Random();
	//转成十六进制
	String hash1 = Integer.toHexString(rdm.nextInt());
	System.out.print(hash1);
	// 得到随机
	for (int i = 0; i < 50; i++) {
		int x = rdm.nextInt(width);
		int y = rdm.nextInt(height);
		g.drawOval(x, y, 0, 0);
	}
	// 生成随机数
	String capstr = hash1.substring(0, 4);
	//在session中存储随机验证码
	session.setAttribute("key", capstr);
	g.setColor(new Color(0, 100, 0));
	//设置字体
	g.setFont(new Font("Candara", Font.BOLD, 24));
	//将验证码画出
	g.drawString(capstr, 8, 24);
	g.dispose();
	//设置返回的页面内容为图片
	response.setContentType("image/jpeg");
	out.clear();
	out = pageContext.pushBody();
	//输出
	OutputStream strm = response.getOutputStream();
	ImageIO.write(image, "jpeg", strm);
	strm.close();
%>