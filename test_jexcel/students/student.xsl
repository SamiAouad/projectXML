<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0">
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <tr>
                        <th>CNE</th>
                        <th>nom</th>
                        <th>prenom</th>
                        <th>Date de naissance</th>
                    </tr>
                    <xsl:for-each select="students/student">
                        <tr>
                            <td>
                                <xsl:value-of select="@CNE"/>
                            </td>
                            
                            <td>
                                <xsl:value-of select="nom"/>
                            </td>
                            
                            <td>
                                <xsl:value-of select="prenom"/>
                            </td>
                            
                            <td>
                                <xsl:value-of select="dateDeNaiss/year"/>/<xsl:value-of select="dateDeNaiss/month"/>/<xsl:value-of select="dateDeNaiss/day"/> 
                            </td>

                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>