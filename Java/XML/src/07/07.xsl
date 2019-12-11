<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method='html' version='1.0' encoding='utf-8' indent='yes'/>
    <xsl:template match="student">
            <html>
                <head>
                    <title>学生成绩表</title>
                </head>
                <body>
                    <table border="1">
                        <tr>
                        <th>课程名称</th>
                        <th>考试日期</th>
                        <th>成绩</th>
                        </tr>
                    <xsl:for-each select="course">
                        <tr>
                        <td><xsl:value-of select="title"/></td>
                        <td><xsl:value-of select="date"/></td>
                        <td><xsl:value-of select="score"/></td>
                        </tr>
                    </xsl:for-each>
                    </table>
                </body>
            </html>
        </xsl:template>
</xsl:stylesheet>