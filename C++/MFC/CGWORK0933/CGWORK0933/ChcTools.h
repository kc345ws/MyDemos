#pragma once
class ChcTools
{
public:
	ChcTools();
	~ChcTools();
	//void DDALine(HDC hdc , CPoint startpoint, CPoint endpoint,  COLORREF color);//DDA�߶�ɨ��ת���㷨
	void DDALine(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color);//DDA�߶�ɨ��ת���㷨
	void DrawRectangle(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color);//������

	void MidpointCircle(CDC *cdc, CPoint circularPoint, float R, COLORREF color);//��1/8Բ
	void DrawOtherCirclePoint(CDC *cdc, CPoint circularPoint,int x , int y, COLORREF color);//������Բ���ĵĵ�
	void DrawCircular(CDC *cdc, CPoint startpoint, CPoint endpoint, COLORREF color);//��Բ��
	
};

