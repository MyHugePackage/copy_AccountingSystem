<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ProductDAO"%>
<%@ page import="com.dto.ProductDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>

<table>
<tr>
<th>prod_no</th><th>prod_class_name</th><th>prod_name</th><th>price</th>
</tr>
<%
ProductDAO productDAO = new ProductDAO();
ArrayList<ProductDTO> dtos  = productDAO.selectProductDTO();

for(int i = 0 ; i < dtos.size() ; i++){
	ProductDTO dto = dtos.get(i);

	String  prod_no = dto.getProd_no();
	String  prod_class_name = dto.getProd_class_name();
	String  prod_name = dto.getProd_name();
	int price = dto.getPrice();

	out.println("<tr><td>"+prod_no+"</td><td>"+prod_class_name+"</td><td>"+prod_name+"</td><td>"+price+"</td></tr>");
}

%>
</table>
<!--
mysql>
SELECT prod_no, prod_class_name, prod_name, price
FROM t_product INNER JOIN m_product_class
ON t_product.prod_class_code = m_product_class.prod_class_code;
-->

<!--
+---------+------------------+--------------------+--------+
| prod_no | prod_class_name  | prod_name          | price  |
+---------+------------------+--------------------+--------+
| A00001  | パソコン         | パソコン01         | 110000 |
| A00002  | パソコン         | パソコン02         | 120000 |
| A00003  | パソコン         | パソコン03         | 130000 |
| B00001  | 家電             | 家電01             | 140000 |
| B00002  | 家電             | 家電02             | 150000 |
| B00003  | 家電             | 家電03             | 160000 |
| C00001  | AV機器           | AV機器01           | 170000 |
| C00002  | AV機器           | AV機器02           | 180000 |
| C00003  | AV機器           | AV機器03           | 190000 |
| D00001  | カメラ           | カメラ01           | 200000 |
| D00002  | カメラ           | カメラ02           | 210000 |
| D00003  | カメラ           | カメラ03           | 220000 |
| E00001  | 玩具             | 玩具01             | 230000 |
| E00002  | 玩具             | 玩具02             | 240000 |
| E00003  | 玩具             | 玩具03             | 250000 |
| F00001  | 時計             | 時計01             | 260000 |
| F00002  | 時計             | 時計02             | 270000 |
| F00003  | 時計             | 時計03             | 280000 |
| G00001  | ゲーム           | ゲーム01           | 290000 |
| G00002  | ゲーム           | ゲーム02           | 300000 |
| G00003  | ゲーム           | ゲーム03           | 310000 |
| H00001  | スポーツ用品     | スポーツ用品01     | 320000 |
| H00002  | スポーツ用品     | スポーツ用品02     | 330000 |
| H00003  | スポーツ用品     | スポーツ用品03     | 340000 |
| I00001  | 携帯電話、スマホ | 携帯電話、スマホ01 | 350000 |
| I00002  | 携帯電話、スマホ | 携帯電話、スマホ02 | 360000 |
| I00003  | 携帯電話、スマホ | 携帯電話、スマホ03 | 370000 |
| J00001  | ペット           | ペット01           | 380000 |
| J00002  | ペット           | ペット02           | 390000 |
| J00003  | ペット           | ペット03           | 400000 |
| K00001  | 健康用品         | 健康用品01         | 410000 |
| K00002  | 健康用品         | 健康用品02         | 420000 |
| K00003  | 健康用品         | 健康用品03         | 430000 |
| L00001  | 書籍             | 書籍01             | 440000 |
| L00002  | 書籍             | 書籍02             | 450000 |
| L00003  | 書籍             | 書籍03             | 460000 |
| M00001  | 文房具           | 文房具01           | 470000 |
| M00002  | 文房具           | 文房具02           | 480000 |
| M00003  | 文房具           | 文房具03           | 490000 |
| N00001  | バッグ           | バッグ01           | 500000 |
| N00002  | バッグ           | バッグ02           | 510000 |
| N00003  | バッグ           | バッグ03           | 520000 |
| O00001  | 記録メディア     | 記録メディア01     | 530000 |
| O00002  | 記録メディア     | 記録メディア02     | 540000 |
| O00003  | 記録メディア     | 記録メディア03     | 550000 |
+---------+------------------+--------------------+--------+
-->
</body>
</html>