
// CGWORK0933View.h: CCGWORK0933View 类的接口
//

#pragma once


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
	enum DrawTypes
	{
		LINE,
		RECTANGLE,
		CIRCULAR
	};
	afx_msg void OnDrawLine();
	afx_msg void OnDrawCircular();
	afx_msg void OnDrawSetColor();
	CPen m_Pen;//绘图时的笔
	COLORREF m_PenColor;
};

#ifndef _DEBUG  // CGWORK0933View.cpp 中的调试版本
inline CCGWORK0933Doc* CCGWORK0933View::GetDocument() const
   { return reinterpret_cast<CCGWORK0933Doc*>(m_pDocument); }
#endif

