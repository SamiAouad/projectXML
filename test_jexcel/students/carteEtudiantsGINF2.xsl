<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="carteEtudiant" page-height="55mm" page-width="85mm" >
                    <fo:region-body region-name="only_region"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="carteEtudiant">
                <fo:flow flow-name="only_region">
                    <xsl:call-template name="main"/>
                    
                </fo:flow>
            </fo:page-sequence>        
            
        </fo:root>
       
    </xsl:template>
    
    <xsl:template match="students" name="main">
        <xsl:variable name="user" select="document('../user.xml')"/>
        <xsl:variable name="cne" select="$user/user/cne"/>
        <xsl:variable name="student" select="students/student[@CNE=$cne]"/>
        <fo:table table-layout="fixed"> 
            <fo:table-body>
                <fo:table-row
                    border-bottom-width="2pt" 
                    border-bottom-style="solid" 
                    border-bottom-color="black" 
                    font-weight="bold" 
                    text-align="center"
                    margin-bottom=" 1cm" 
                    margin-left="0px"
                    background-color="#6998AB"
                    color="#ffffff"
                    height="15mm">
                    
                    <fo:table-cell text-align="left">
                        <fo:block
                            >
                            <fo:external-graphic content-height="10mm" content-width="auto" src="url(File:C:/Users/pc/Documents/NetBeansProjects/projetXML/test_jexcel/images/logoENSAT.png)"/>
                        </fo:block>
                        
                    </fo:table-cell>
                    <fo:table-cell width="55mm">
                        <fo:block text-align="center"  margin-top="10px" margin-left="5px">
                            Carte d'étudiant
                        </fo:block>
                        
                    </fo:table-cell>
                    <fo:table-cell text-align="right" margin-right="4px">
                        <fo:block
                            >
                            <fo:external-graphic content-height="8mm" content-width="24mm" src="url(../images/logoUni.png)"/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
                
                
                <fo:table-row
                    border-bottom-width="2pt" 
                    border-bottom-style="solid" 
                    border-bottom-color="black" 
                    font-weight="bold" 
                    
                    margin-bottom=" 1cm" 
                    height="35mm"
                    width="85mm"
                    >
                    <fo:table-cell width="35mm">
                        <fo:block text-align="center" margin-left="15mm">
                            <xsl:variable name="cne" select="$student/@CNE"/>
                            <xsl:variable name="image" select="concat('../images/',concat($cne,'.png'))" />
                            <fo:external-graphic padding="15px" content-height="20mm" content-width="auto" src="{$image}"/>
                            
                        </fo:block>
                        <fo:block text-align="center" margin-left="15mm">
                            <xsl:value-of select="$student/@CNE"/>
                        </fo:block>
                        
                    </fo:table-cell>
                    <fo:table-cell width="50mm" >
                        <fo:block text-align="left" margin-left="25mm" margin-top="8mm">
                            <xsl:value-of select="$student/nom"/>
                        </fo:block>
                        <fo:block text-align="left" margin-left="25mm">
                            <xsl:value-of select="$student/prenom"/>
                        </fo:block>
                        <fo:block text-align="left" margin-left="25mm">
                            <xsl:value-of select="$student/dateDeNaiss/day"/>/<xsl:value-of select="$student/dateDeNaiss/month"/>/<xsl:value-of select="$student/dateDeNaiss/year"/>
                        </fo:block>
                        <fo:block text-align="left" margin-left="25mm" font-size="15px">
                            Année d'inscription: <xsl:value-of select="$student/dateDeNaiss/year"/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
                
                <fo:table-row background-color="#1A374D" height="3mm" width="85mm">
                    <fo:table-cell>
                        <fo:block></fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body >
        </fo:table>
    </xsl:template>
 
</xsl:stylesheet>