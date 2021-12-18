<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="students">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="carteEtudiant" page-height="55mm" page-width="85mm">
                    <fo:region-body region-name="only_region"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="carteEtudiant">
                <fo:flow flow-name="only_region">
                    <xsl:call-template name="main"/>
                    <xsl:call-template name="main2" />
                </fo:flow>
            </fo:page-sequence>
            
            
            
        </fo:root>
        
        
    </xsl:template>
    
    <xsl:template match="students/student[@CNE='B12']" name="main">
        <fo:table  > 
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block border-bottom-width="2pt" 
                            border-bottom-style="solid" 
                            border-bottom-color="black" 
                            font-weight="bold" 
                            text-align="center"
                            margin-bottom=" 1cm"
                            text-align-last="center" 
                            margin-left="0.5cm"
                            >
                            Université Abdelmalik Essâadi - ENSA de Tanger 
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body >
        </fo:table>
    </xsl:template>
    
    <xsl:template match="students/student[@CNE='B12']" name="main2">
        <fo:table  > 
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block border-bottom-width="2pt" 
                            border-bottom-style="solid" 
                            border-bottom-color="black" 
                            font-weight="bold" 
                            text-align="center"
                            margin-bottom=" 1cm"
                            text-align-last="center" 
                            margin-left="0.5cm"
                            >
                            ENSA de Tanger 
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body >
        </fo:table>
    </xsl:template>
    
    
</xsl:stylesheet>