
// CGWORK0933View.cpp: CCGWORK0933View 类的实现
//

#include "stdafx.h"
// SHARED_HANDLERS 可以在实现预览、缩略图和搜索筛选器句柄的
// ATL 项目中进行定义，并允许与该项目共享文档代码。
#ifndef SHARED_HANDLERS
#include "CGWORK0933.h"
#endif

#include "CGWORK0933Doc.h"
#include "CGWORK0933View.h"
#include"ChcTools.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CCGWORK0933View

IMPLEMENT_DYNCREATE(CCGWORK0933View, CView)

BEGIN_MESSAGE_MAP(CCGWORK0933View, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
	ON_COMMAND(ID_DRAW_RECT, &CCGWORK0933View::OnDrawRect)
	ON_WM_LBUTTONDBLCLK()//消息和消息处理函数的映射
	ON_WM_LBUTTONDOWN()
	ON_WM_LBUTTONUP()
	ON_WM_MOUSEMOVE()
	ON_COMMAND(ID_DRAW_LINE, &CCGWORK0933View::OnDrawLine)
	ON_COMMAND(ID_DRAW_CIRCULAR, &CCGWORK0933View::OnDrawCircular)
	ON_COMMAND(ID_DRAW_SET_COLOR, &CCGWORK0933View::OnDrawSetColor)
END_MESSAGE_MAP()

// CCGWORK0933View 构造/析构

CCGWORK0933View::CCGWORK0933View() noexcept
{
	// TODO: 在此处添加构造代码
	m_LButtonDown = false;//默认鼠标左键未按下
	m_DrawType = LINE;//默认直线
	m_isDraw = true;
	
	m_PenColor = RGB(0, 0, 0);
	m_Pen.CreatePen(PS_SOLID, 3, RGB(42, 67, 23));
}

CCGWORK0933View::~CCGWORK0933View()
{

}

BOOL CCGWORK0933View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CCGWORK0933View 绘图

void CCGWORK0933View::OnDraw(CDC* /*pDC*/)
{
	CCGWORK0933Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;



	CClientDC dc(this);


	dc.SelectObject(m_Pen);
	dc.LineTo(400, 500);
	for (int i = 100; i < 300; i++) {
		dc.SetPixel(i, i, m_PenColor);
	}
;
	// TODO: 在此处为本机数据添加绘制代码
}


// CCGWORK0933View 打印

BOOL CCGWORK0933View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CCGWORK0933View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CCGWORK0933View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}


// CCGWORK0933View 诊断

#ifdef _DEBUG
void CCGWORK0933View::AssertValid() const
{
	CView::AssertValid();
}

void CCGWORK0933View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CCGWORK0933Doc* CCGWORK0933View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CCGWORK0933Doc)));
	return (CCGWORK0933Doc*)m_pDocument;
}
#endif //_DEBUG


// CCGWORK0933View 消息处理程序

//选择此菜单项后，可利用鼠标在视图区绘制矩形； 
void CCGWORK0933View::OnDrawRect()
{
	// TODO: 在此添加命令处理程序代码
	m_DrawType = RECTANGLE;
}

//画直线
void CCGWORK0933View::OnDrawLine()
{
	// TODO: 在此添加命令处理程序代码
	m_DrawType = LINE;	
}

//鼠标左键双击消息函数
void CCGWORK0933View::OnLButtonDblClk(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	CView::OnLButtonDblClk(nFlags, point);
}

//鼠标左键按下消息函数
void CCGWORK0933View::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值
	if (m_isDraw) {
		DrawLButtonDown(nFlags, point);
	}
	CView::OnLButtonDown(nFlags, point);
}

//鼠标左键抬起消息函数
void CCGWORK0933View::OnLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值


	/*
	我们发现在函数中已经添加了一句代码，这行代码是调用对应的父类的鼠标消息处理函数
	进行一些默认处理。我们所添加的代码都必须添加到该句代码之前，并且此句代码不能删除，
	否则将会出错。同时需要注意的是，Windows的鼠标消息发生的间隔是一秒钟，并不是所有的
	鼠标动作都会产生鼠标消息。假设你按鼠标左键的速度足够快，在一秒钟内可以按鼠标左键多
	次，则并不是每次按键都会产生鼠标消息，只有第一次按键以及后面按键与前一次按键的时间
	间隔在一秒钟以上的那些按键才会产生鼠标消息。
	*/
	if (m_isDraw) {
		DrawLButtonUp(nFlags, point);
	}
	CView::OnLButtonUp(nFlags, point);
}

//鼠标移动消息函数
void CCGWORK0933View::OnMouseMove(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值
	if (m_isDraw) {
		DrawMouseMove(nFlags, point);
	}
	CView::OnMouseMove(nFlags, point);
}


// 鼠标绘图时鼠标左键按下消息处理函数
void CCGWORK0933View::DrawLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: 在此处添加实现代码.


	this->SetCapture();//捕获鼠标
	m_StartPoint = point;
	m_EndPoint = point;
	m_LButtonDown = true;

	CClientDC CDC(this);
	CDC.SelectObject(m_Pen);
}


// 鼠标绘图时鼠标移动消息处理函数
void CCGWORK0933View::DrawMouseMove(UINT nFlags, CPoint point)
{
	// TODO: 在此处添加实现代码.
	//CClientDC cdc(this);
	//CDC *cdc = GetDC();
	CClientDC *cdc = (CClientDC*)GetDC();
	cdc->SelectObject(m_Pen);
	

	if (m_LButtonDown) {
		//如果鼠标左键还在按下状态
		//cdc->SetROP2(R2_NOT);//设置绘图模式为R2_NOT模式
		cdc->SetROP2(R2_NOTXORPEN);
		/*
		//重新绘制前一个鼠标移动消息处理函数绘制的直线段
		//因为绘图模式的原因，结果是擦除了该线段
		*/
		if (m_DrawType == LINE) {
			/*//如果是画直线
			CDC.MoveTo(m_StartPoint);
			CDC.LineTo(m_EndPoint);

			//绘制新的直线段
			CDC.MoveTo(m_StartPoint);
			CDC.LineTo(point);
			//保存新的直线段终点
			m_EndPoint = point;*/
			ChcTools chc;
			cdc->MoveTo(m_StartPoint);
			
			chc.DDALine(cdc, m_StartPoint, m_EndPoint, m_PenColor);

			cdc->MoveTo(m_StartPoint);
			chc.DDALine(cdc, m_StartPoint, point, m_PenColor);

			m_EndPoint = point;
		}
		else if (m_DrawType == RECTANGLE) {
			//画矩形
			ChcTools chc;
			
			
			cdc->MoveTo(m_StartPoint);

			chc.DrawRectangle(cdc, m_StartPoint, m_EndPoint, m_PenColor);

			cdc->MoveTo(m_StartPoint);
			chc.DrawRectangle(cdc, m_StartPoint, point, m_PenColor);


			//保存新的直线段终点
			m_EndPoint = point;
		}
		else if (m_DrawType == CIRCULAR) {
			//画矩形
			ChcTools chc;


			cdc->MoveTo(m_StartPoint);
			double oldR = sqrt(fabs((m_EndPoint.x - m_StartPoint.x)*(m_EndPoint.x - m_StartPoint.x)
			) + (m_EndPoint.y - m_StartPoint.y)*(m_EndPoint.y - m_StartPoint.y));
			chc.MidpointCircle(cdc, m_StartPoint, oldR, m_PenColor);

			double newR = sqrt(fabs((point.x - m_StartPoint.x)*(point.x - m_StartPoint.x)
			) + ((point.y - m_StartPoint.y)*(point.y - m_StartPoint.y)));
			cdc->MoveTo(m_StartPoint);
			chc.MidpointCircle(cdc, m_StartPoint, newR, m_PenColor);

			m_EndPoint = point;
		}
	}
	/*
		因为m_EndPoint中存放的一直是上次调用鼠标移动消息处理函数时鼠标光标所处的位置，
		所以绘制m_StartPoint和m_EndPoint之间的直线段时，该直线段已经存在了，因为绘图
		模式的关系，本次绘图就起到了将原来的线段擦除的功能。在m_StartPoint和point之间
		绘制直线段，此时point点是新的位置，所以原来视图区中不会有该直线段存在，则此时
		绘图实际在视图区中绘制了一条从m_StartPoint到point的直线段。最后将m_EndPoint赋
		值为point，保证下一次执行鼠标移动消息处理函数时可以正确的将本次执行时绘制的直
		线段擦除掉。*/
}


// 鼠标绘图时鼠标左键抬起消息处理函数
void CCGWORK0933View::DrawLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: 在此处添加实现代码.
	m_LButtonDown = false;
	//m_isDraw = false;
	ReleaseCapture();//释放鼠标
	//CClientDC CDC(this);//构造设备环境对象

	//绘制最终要绘制的直线段
	/*if (m_DrawType == LINE) {
		CDC.MoveTo(m_StartPoint);
		CDC.LineTo(m_EndPoint);
	}*/
}



//
void CCGWORK0933View::OnDrawCircular()
{
	// TODO: 在此添加命令处理程序代码
	m_DrawType = CIRCULAR;
}

//设置颜色
void CCGWORK0933View::OnDrawSetColor()
{
	// TODO: 在此添加命令处理程序代码
	COLORREF color = RGB(0, 0, 0);
	CColorDialog cdlg(color, CC_FULLOPEN | CC_RGBINIT); // 设置默认颜色

	if (cdlg.DoModal()) {
		color = cdlg.GetColor();

		//m_Pen.CreatePen(PS_NULL, 0, color);
		
		m_Pen.DeleteObject();
		m_Pen.CreatePen(PS_SOLID, 10, color);

		m_PenColor = color;
	}
}
