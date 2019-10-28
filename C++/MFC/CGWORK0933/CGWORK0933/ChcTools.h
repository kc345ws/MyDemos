#pragma once
class ChcTools
{
public:
	ChcTools();
	~ChcTools();
	//void DDALine(HDC hdc , CPoint startpoint, CPoint endpoint,  COLORREF color);//DDA线段扫描转换算法
	void DDALine(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color);//DDA线段扫描转换算法
	void DrawRectangle(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color);//画矩形

	void MidpointCircle(CDC *cdc, CPoint circularPoint, float R, COLORREF color);//画1/8圆
	void DrawOtherCirclePoint(CDC *cdc, CPoint circularPoint,int x , int y, COLORREF color);//画其他圆弧的的点
	void DrawCircular(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color);//画圆形
	
};

