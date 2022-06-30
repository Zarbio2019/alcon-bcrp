<p>
Se debe crear una carpeta con la version en la que sera desplegada ;

El archivo debe estar separado en: 
	<ul>
		<li>1tablas.sql</li>
		<li>2sps.sql</li>
		<li>3datos.sql</li>
	</ul>
</p>

<p>

Colocar una linea de comentario entre requerimiento :
</br>
-- Inicio PAMDRCDM-58
</br>
sentencias SQL
</br>
-- Fin PAMDRCDM-58
</br>

</p>


El archivo debe estar separado en: 
	<ul>
		<li> tablas.sql</li>
		<li> sp.sql  </li>
		<li> datos.sql </li>
	</ul>
</p>



<h1>1.-Procedimientos almacenados</h1>
	<h2>Consideraciones</h2>
	<ul>
		<li> Solo debe contener la orden de create</li>
		<li> No debe tener la secuencia editionable  </li>
		<li> Verificarse en SQLPLUS (sqlplus.exe PCBCRP/rkpuaNFqVbRMmUS@TLBDFORACLE.pe.igrupobbva/TST12C)</li>
		
	</ul>
	<h2>Estructura</h2>
	<ul>
		<li>DROP DE SPS</li>
		<li>ESTRUCTURA DE LOS SPS</li>
		<li>GRANT DEL SP</li>
	</ul>


<h1>2.-TABLAS</h1>
	<h2>Consideraciones</h2>
	<ul>
		<li> Usar solo funciones standar de sql (no tablespace)</li>
	</ul>
	<h2>Estructura</h2>
	<ul>
		<li>ESTRUCTURA DEL CAMBIO</li>
		<li>GRANT DE LA TABLA</li>
	</ul>

	
	