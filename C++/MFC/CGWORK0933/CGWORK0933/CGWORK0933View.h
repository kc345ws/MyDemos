﻿
// CGWORK0933View.h: CCGWORK0933View 类的接口
//

#pragma once
#include <list>
#include <random>

class ThPoint {
public:
	int x;
	int y;
	int z;

	ThPoint(int x, int y, int z) {
		this->x = x;
		this->y = y;
		this->z = z;
	}

	ThPoint() {}
};


class CCGWORK0933View : public CView
{
protected: // 仅从序列化创建
	CCGWORK0933View() noexcept;
	DECLARE_DYNCREATE(CCGWORK0933View)

// 特性
public:
	CCGWORK0933Doc* GetDocument() const;

// 操作
public:

// 重写
public:
	virtual void OnDraw(CDC* pDC);  // 重写以绘制该视图
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);

// 实现
public:
	virtual ~CCGWORK0933View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// 生成的消息映射函数
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnDrawRect();
	afx_msg void OnLButtonDblClk(UINT nFlags, CPoint point);//消息处理函数
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg void OnLButtonUp(UINT nFlags, CPoint point);
	afx_msg void OnMouseMove(UINT nFlags, CPoint point);

	// 鼠标绘图时鼠标左键按下消息处理函数
	void DrawLButtonDown(UINT nFlags, CPoint point);
	// 鼠标绘图时鼠标移动消息处理函数
	void DrawMouseMove(UINT nFlags, CPoint point);
	// 鼠标绘图时鼠标左键抬起消息处理函数
	void DrawLButtonUp(UINT nFlags, CPoint point);
	CPoint m_StartPoint;//鼠标绘图开始点坐标
	CPoint m_EndPoint;//鼠标绘图终止点坐标
	bool m_LButtonDown;//鼠标左键是否按下
	bool m_isDraw;//是否在绘制
	int m_DrawType;//绘制图形类型
	enum DrawTypes//绘制图形最的种类
	{
		LINE,
		RECTANGLE,
		CIRCULAR
	};
	afx_msg void OnDrawLine();//画直线
	afx_msg void OnDrawCircular();//画圆形
	afx_msg void OnDrawSetColor();//设置画笔颜色
	CPen m_Pen;//绘图时的笔
	COLORREF m_PenColor;//画笔颜色
	afx_msg void OnDrawPolygon();//绘制多边形
	afx_msg void OnSetPolygonColor();//绘制多边形设置填充颜色
	bool m_isDrawPoly;//是否在绘制多边形
//	bool m_isEndRrawPoly;
//是否结束多边形绘制
	int m_PolyCount;
	afx_msg void OnInvalidate();
	// 获取点中y坐标最大值
//	int GetMaxY();
//	void Fill(CDC*& pDC, int x, int y, COLORREF& oldColor, COLORREF& newColor);
	std::list<CPoint> m_PloyCpoints;
	afx_msg void OnKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags);
	afx_msg void OnDrawCube();
//	afx_msg void OnContextMenu(CWnd* /*pWnd*/, CPoint /*point*/);
//	afx_msg void OnSize(UINT nType, int cx, int cy);
//	int cxClient;
//	int cyClient;
	void DrawRect(CPoint p1, CPoint p2, CPoint p3, CPoint p4,bool isfill = true);//画矩形
	void DrawCube();//画立方体
	void From3dTo2d();//从二维坐标转换为三维坐标
	void Fill(CPoint[]);//填充立方体的面

	
	ThPoint m_CubeThPoints[8];
	CPoint m_Cube2DPoints[8];//立方体顶点2D坐标
	void Perspective();//透视投影矩阵
	void ClearScreen();//清屏

	// 投影矩阵
	double m_Proj_Matri[4][4];
	
	afx_msg void OnRoatez();
	virtual BOOL PreTranslateMessage(MSG* pMsg);
};


#ifndef _DEBUG  // CGWORK0933View.cpp 中的调试版本
inline CCGWORK0933Doc* CCGWORK0933View::GetDocument() const
   { return reinterpret_cast<CCGWORK0933Doc*>(m_pDocument); }
#endif

