<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h3 align = "center">米菲的简历</h3>
                <table border="1"  align = "center" cellpadding="10"><!--CCFFFF-->
                    <tr>
                        <td bgcolor="#ADD8E6" width = "70" align = "center">姓名</td>
                        <td bgcolor="#E0FFFF" width = "300"><xsl:value-of select="/学生/个人基本信息/姓名"/></td>
                        <td rowspan="6">
                            <img>
                                <xsl:attribute name="src"><xsl:value-of select="/学生/个人基本信息/照片" /></xsl:attribute>
                            </img>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center">性别</td>
                        <td bgcolor="#E0FFFF"><xsl:value-of select="/学生/个人基本信息/性别"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center">民族</td>
                        <td bgcolor="#E0FFFF"><xsl:value-of select="/学生/个人基本信息/民族"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center">出生地</td>
                        <td bgcolor="#E0FFFF"><xsl:value-of select="/学生/个人基本信息/出生地"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center">通讯地址</td>
                        <td bgcolor="#E0FFFF">
                            <xsl:for-each select="/学生/个人基本信息/通讯地址/条目">
                                <ul>
                                    <li><xsl:value-of select="."/></li>
                                </ul>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center">电邮</td>
                        <td bgcolor="#E0FFFF"><xsl:value-of select="/学生/个人基本信息/电子邮件"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center" colspan = "3">学历和工作简历</td>
                    </tr>
                    <tr>
                        <td bgcolor="#E0FFFF" colspan = "3">
                            <xsl:for-each select="/学生/学历和工作简历/条目">
                                <ul>
                                    <li><xsl:value-of select="."/></li>
                                </ul>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center" colspan = "3">已修课程</td>
                    </tr>
                    <tr>
                        <td bgcolor="#E0FFFF" colspan = "3">
                            <xsl:for-each select="/学生/已修课程/条目">
                                <ul>
                                    <li><xsl:value-of select="."/></li>
                                </ul>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center" colspan = "3">已获奖励</td>
                    </tr>
                    <tr>
                        <td bgcolor="#E0FFFF" colspan = "3">
                            <xsl:for-each select="/学生/已获奖励/条目">
                                <ul>
                                    <li><xsl:value-of select="."/></li>
                                </ul>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ADD8E6" align = "center" colspan = "3">已发表论文</td>
                    </tr>
                    <tr>
                        <td bgcolor="#E0FFFF" colspan = "3">
                            <xsl:for-each select="/学生/已发表论文/条目">
                                <ul>
                                    <li><xsl:value-of select="."/></li>
                                </ul>
                            </xsl:for-each>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>