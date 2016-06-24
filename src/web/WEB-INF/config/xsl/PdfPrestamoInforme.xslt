<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	<xsl:output method="fo"/>
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simple" page-height="29.7cm" page-width="21cm" margin-top="1cm" margin-bottom="2cm" margin-left="2.5cm" margin-right="2.5cm">
					<fo:region-body margin-top="3cm" column-count="3"/>
					<fo:region-before extent="3cm"/>
					<fo:region-after extent="1.5cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simple">
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="result"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="result">
		<xsl:for-each select="./Prestamo">
			<fo:table table-layout="fixed" border-style="solid" border-width="0.1mm">
				<fo:table-column column-width="16cm"/>			
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell text-align="center" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed" background-color="#F0F0F0">
							<fo:block>
								VEH�CULO DE SUSTITUCI�N
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>
				</fo:table-body>
			</fo:table>		
			<fo:table table-layout="fixed" border-style="solid" border-width="0.1mm">
				<fo:table-column column-width="8cm"/>
				<fo:table-column column-width="8cm"/>			
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Matr�cula : <xsl:value-of select="VehiculoCortesiaMatriculaPrestamo"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Orden de Reparaci�n: <xsl:value-of select="ReparacionIdPrestamo"/>
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Modelo : <xsl:value-of select="VehiculoCortesiaModeloPrestamo"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Cia Seguro: 
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								N� Bastidor : <xsl:value-of select="VehiculoCortesiaChasisPrestamo"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								N� P�liza: 
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Fecha Salida : <xsl:value-of select="FechaIniPrestamoParsed"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Fecha Entrada: <xsl:value-of select="FechaFinPrestamoParsed"/>
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>
					<fo:table-row>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Hora : <xsl:value-of select="HoraIniPrestamoParsed"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								Hora: <xsl:value-of select="HoraFinPrestamoParsed"/>
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>																				
				</fo:table-body>
			</fo:table>
			<fo:table table-layout="fixed" border-style="solid" border-width="0.1mm">
				<fo:table-column column-width="16cm"/>			
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								1� El cliente ha confiado previamente, para su reparaci�n, el veh�culo de su propiedad matr�cula <xsl:value-of select="ReparacionVehiculoMatriculaPrestamo"/> seg�n la orden de reparaci�n n� <xsl:value-of select="ReparacionIdPrestamo"/>.
							</fo:block>								
							<fo:block>								
								2� En relaci�n con lo anterior, el cliente ha solicitado al taller un veh�culo de sustituci�n, en las condiciones de utilizaci�n que se exponen a continuaci�n y el taller ha accedido a esa solicitud.
							</fo:block>								
							<fo:block>								
								3� Este documento efect�a, al amparo y de acuerdo con el escrito de contestaci�n a consulta, emitido por la Direcci�n General del Transporte Terrestre, del Ministerio de Obras P�blicas y Transportes de fecha 15-10-1992 por la que se declara no sujeto el mismo, a los requisitos exigidos por la legislaci�n vigente, para las operaciones de alquiler de veh�culos sin conductor.
							</fo:block>								
							<fo:block>								
								4� El cliente declara tener todos los requisitos exigidos por la ley para la conducci�n de un veh�culo, debidamente actualizados y en vigencia.
							</fo:block>								
							<fo:block>								
								5� El cliente se har� responsable de los da�os ocasionados en el veh�culo, as� como de las infracciones, gastos, da�os y perjuicios que se ocasionen durante el periodo en que utilice el veh�culo de sustituci�n.
							</fo:block>								
							<fo:block>								
								6� El cliente declara haber le�do y aceptado las condiciones de utilizaci�n del veh�culo de sustituci�n, haciendo especial menci�n, al tipo de seguro obligatorio y voluntario, as� como a la responsabilidad civil que cubre el mismo y en prueba de conformidad, firma este documento con el Visto Bueno del Taller.
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>
				</fo:table-body>
			</fo:table>
			<fo:table table-layout="fixed" border-style="solid" border-width="0.1mm">
				<fo:table-column column-width="4cm"/>
				<fo:table-column column-width="6cm"/>
				<fo:table-column column-width="6cm"/>				
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								V� B� TALLER
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								FIRMAS DEL CLIENTE: ENTREGA
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="left" padding-after="0.1cm" padding-before="0.1cm" border-style="solid" border-width="0.1mm" table-layout="fixed">
							<fo:block>
								DEVOLUCI�N DEL VEH�CULO
							</fo:block>
						</fo:table-cell>						
					</fo:table-row>
				</fo:table-body>
			</fo:table>																																
		</xsl:for-each>	
	</xsl:template>
</xsl:stylesheet>
