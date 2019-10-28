#include "stdafx.h"
#include "ChcTools.h"
#include<math.h>


ChcTools::ChcTools()
{

}


ChcTools::~ChcTools()
{

}



//DDA线段扫描转换算法
/*void ChcTools::DDALine(HDC hdc,CPoint startpoint, CPoint endpoint , COLORREF color)
{


	double dx, dy, e, x, y;
	dx = endpoint.x - startpoint.x;
	dy = endpoint.y - startpoint.y;
	
	if (fabs(dx) > fabs(dy)) {
		e = dx;//如果X轴为长边，则将X坐标作为标准
	}
	else {
		e = dy;
	}

	if (e == 0) {
		return;
	}

	dx /= e;
	dy /= e;//计算增加步长，长边等于1，短边小于1	

	if (e > 0) {
		x = startpoint.x;
		y = startpoint.y;
		for (int i = 0; i < e; i++) {
			SetPixel(hdc, (int)(x + 0.5), (int)(y + 0.5), color);
			
			//SetPixel(hdc, (int)(x + 0.5), (int)(y + 0.5), color);
			x += dx;
			y += dy;
		}
	}
	else {
		x = endpoint.x;
		y = endpoint.y;
		for (int i = e; i < 0; i++) {
			SetPixel(hdc, (int)(x + 0.5), (int)(y + 0.5), color);
			x += dx;
			y += dy;
		}
	}
}*/

void ChcTools::DDALine(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color)
{

	double dx, dy, e, x, y;
	dx = endpoint.x - startpoint.x;
	dy = endpoint.y - startpoint.y;

	if (fabs(dx) > fabs(dy)) {
		e = dx;//如果X轴为长边，则将X坐标作为标准
	}
	else {
		e = dy;
	}

	if (e == 0) {
		return;
	}

	dx /= e;
	dy /= e;//计算增加步长，长边等于1，短边小于1	

	if (e > 0) {
		x = startpoint.x;
		y = startpoint.y;
		for (int i = 0; i < e; i++) {
			//SetPixel(hdc, (int)(x + 0.5), (int)(y + 0.5), color);
			cdc->SetPixel((int)(x + 0.5), (int)(y + 0.5), color);

			//SetPixel(hdc, (int)(x + 0.5), (int)(y + 0.5), color);
			x += dx;
			y += dy;
		}
	}
	else {
		x = endpoint.x;
		y = endpoint.y;
		for (int i = e; i < 0; i++) {
			//SetPixel(hdc, (int)(x + 0.5), (int)(y + 0.5), color);
			cdc->SetPixel((int)(x + 0.5), (int)(y + 0.5), color);
			x += dx;
			y += dy;
		}
	}
}

//画矩形
void ChcTools::DrawRectangle(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color)
{
	CPoint p1(endpoint.x, startpoint.y);
	CPoint p2(startpoint.x, endpoint.y);

	DDALine(cdc, startpoint, p1, color);
	DDALine(cdc, startpoint, p2, color);
	DDALine(cdc, p1, endpoint, color);
	DDALine(cdc, p2, endpoint, color);
}

//中点画圆法1/8圆
void ChcTools::MidpointCircle(CDC *cdc, CPoint circularPoint, float R, COLORREF color)
{
	
	int x, y;
	double d;
	//第一个点的坐标
	x = circularPoint.x;
	y = circularPoint.y - R; 
	d = 1.25 - R;
	//SetPixel(hdc, x, y, BLACK_PEN);
	DrawOtherCirclePoint(cdc, circularPoint, x, y, color);
	while ((x- circularPoint.x) < -1 * (y- circularPoint.y)) {
		//因为MFC坐标原点是从窗口左上角开始的，所以要取反
		if (d < 0) {
			//d += 2 * x + 3;
			d += 2 * (x - circularPoint.x) + 3;
			x++;
		}
		else {
			//d += 2 * (x - y) + 5;
			d += 2 * ((x - circularPoint.x) - (-1) * (y - circularPoint.y)) + 5;
			x++;
			y++;
		}
		//SetPixel(hdc, x, y, BLACK_PEN);
		DrawOtherCirclePoint(cdc, circularPoint ,x, y, color);
	}

	
	

	/*int x, y;
	double d;
	x = 0; y = R; d = 1.25 - R;
	SetPixel(hdc, x, y, BLACK_PEN);
	while (x < y) {
		if (d < 0) {
			d += 2 * x + 3;
			x++;
		}
		else {
			d += 2 * (x - y) + 5;
			x++;
			y--;
		}
		SetPixel(hdc, x, y, BLACK_PEN);
	}*/
}

void ChcTools::DrawOtherCirclePoint(CDC *cdc, CPoint circularPoint, int x, int y, COLORREF color)
{
	int cirx = circularPoint.x;
	int ciry = circularPoint.y;//原点坐标


	//int x = Point.x;//在第一个八分之一圆弧的点
	//int y = Point.y;
	//SetPixel(cdc, x, y, color);
	cdc->SetPixel(x, y, color);
	cdc->SetPixel(2 * cirx - x, 2 * ciry - y, color);
	//SetPixel(cdc, 2*cirx -x, 2*ciry-y, color);//关于圆心对称

	/*if(x != 2 * cirx - x)
	SetPixel(hdc, x, 2 * ciry - y, BLACK_PEN);//关于X轴对称
	if(y != 2 * ciry - y)
	SetPixel(hdc, 2 * cirx - x, y, BLACK_PEN);//关于Y轴对称*/
	if (fabs(x - (2 * cirx - x)) > 1) {
		//SetPixel(hdc, x, 2 * ciry - y, color);//关于X轴对称
		//SetPixel(hdc, 2 * cirx - x, y, color);//关于Y轴对称*/
		cdc->SetPixel(x, 2 * ciry - y, color);
		cdc->SetPixel(2 * cirx - x, y, color);
	}
	/*if (fabs(y - (2 * ciry - y)) > 1) {
		//SetPixel(hdc, 2 * cirx - x, y, BLACK_PEN);//关于Y轴对称
	}*/

	/*SetPixel(hdc, y, x, BLACK_PEN);
	SetPixel(hdc, y, 2 * cirx - x, BLACK_PEN);
	SetPixel(hdc, 2 * ciry - y, 2 * cirx - x, BLACK_PEN);
	SetPixel(hdc, y, 2 * cirx - x, BLACK_PEN);*/

	int disx = fabs(cirx - x);//X与圆心的距离
	int disy = fabs(ciry - y);

	if (fabs(disy - disx)>1) {//防止重复画，导致原图像被清除
		//SetPixel(hdc, cirx + disy, ciry - disx, color);//第一象限
		cdc->SetPixel(cirx + disy, ciry - disx, color);

		if (fabs((ciry - disx) - (ciry + disx)) > 1)
			cdc->SetPixel(cirx + disy, ciry + disx, color);
		//SetPixel(hdc, cirx + disy, ciry + disx, color);//第四象限
			



		//SetPixel(hdc, cirx - disy, ciry - disx, color);//第二象限
		cdc->SetPixel(cirx - disy, ciry - disx, color);

		if (fabs((ciry - disx) - (ciry + disx)) > 1)
			cdc->SetPixel(cirx - disy, ciry + disx, color);
		//SetPixel(hdc, cirx - disy, ciry + disx, color);//第三象限


		
	}
	

	/*if (cirx + disy != ciry + disx)
	

	if (cirx - disy != ciry + disx)
	SetPixel(hdc, cirx - disy, ciry + disx, BLACK_PEN);

	if(cirx - disy != ciry - disx)
	SetPixel(hdc, cirx - disy, ciry - disx, BLACK_PEN);*/
}

void ChcTools::DrawCircular(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color)
{

}
