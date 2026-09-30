TerminalDeCarga.java
import	java.util.Scanner;
public	class	TerminalDeCarga
{
				//	----	Constantes	----
				private	static	final	double	PESO_MAX	=	30;
				private	static	final	double	PESO_MIN	=	15;
				private	static	final	int	MUELLES_MAX	=	5;
				private	static	final	double	CAPACIDAD_BARCAZA	=	10;
				//	----	Tipos	enumerados	----
				enum	TipoCarga	{	ALIMENTOS,	TECNOLOGIA,	AUTOS,	CARGAS_PESADAS,	CONTENEDORES	}
				enum	Turno	{	DIURNO,	NOCTURNO,	MATUTINO	}
				public	static	void	main(String[]	args)
				{
								Scanner	teclado	=	new	Scanner(System.in);
								String	id;
								byte	muelle;
								int	turnoOpcion,	opcionCarga,	ND,	contadorFueraRango	=	0;
								float	pesoDespacho;
								double	pesoTotal	=	0,	barcazasNecesarias;
								char	codigoTarifa;
								boolean	muelleValido,	banderaSobrepeso	=	false;
								TipoCarga	tipoCargamento;
								Turno	turnoTrabajador;
								System.out.println("===	Sistema	de	Registro	-	Terminal	de	Carga	===");
								System.out.print("Ingrese	su	identificacion:	");
								id	=	teclado.next();
								//	---	Repetir-Hasta	(do-while):	validar	el	muelle	---
								do
								{
												System.out.print("Ingrese	el	numero	de	muelle	asignado	(1	a	"	+	MUELLES_MAX	+	"):	");
												muelle	=	teclado.nextByte();
												if	(muelle	>=	1	&&	muelle	<=	MUELLES_MAX)
												{
																muelleValido	=	true;
																System.out.println("Tu	muelle	esta	disponible");
												}
												else
												{
																muelleValido	=	false;
																System.out.println("Tu	muelle	no	se	encuentra	en	esta	terminal,	intenta	de	nuevo");
												}
								}
								while	(!muelleValido);
								//	---	Segun	(switch):	turno	de	trabajo	---
								System.out.print("Ingrese	su	turno	(1=Diurno,	2=Nocturno,	3=Matutino):	");
								turnoOpcion	=	teclado.nextInt();
								switch	(turnoOpcion)
								{
												case	1:
																turnoTrabajador	=	Turno.DIURNO;
																break;
												case	2:
																turnoTrabajador	=	Turno.NOCTURNO;
																break;
												case	3:
																turnoTrabajador	=	Turno.MATUTINO;
																break;
												default:
																System.out.println("Turno	no	valido,	se	asigna	DIURNO	por	defecto");
																turnoTrabajador	=	Turno.DIURNO;
																break;
								}
								System.out.println("Turno	asignado:	"	+	turnoTrabajador);
								System.out.print("Cuantos	despachos	tiene	asignados?	");
								ND	=	teclado.nextInt();
								//	---	Para	(for):	procesar	cada	despacho	---
								for	(int	i	=	1;	i	<=	ND;	i++)
								{
												System.out.println("---	Despacho	"	+	i	+	"	de	"	+	ND	+	"	---");
												System.out.print("Peso	del	cargamento	en	toneladas:	");
												pesoDespacho	=	teclado.nextFloat();
												System.out.println("Tipo	de	carga:	1=Alimentos	2=Tecnologia	3=Autos	4=Cargas	pesadas	5=Contenedores");
												System.out.print("Ingrese	el	tipo	(1	a	5):	");
												opcionCarga	=	teclado.nextInt();
												//	---	Segun	(switch):	clasificar	tipo	de	carga	y	codigo	de	tarifa	---
												switch	(opcionCarga)
												{
																case	1:
																				tipoCargamento	=	TipoCarga.ALIMENTOS;
																				codigoTarifa	=	'A';
																				break;
																case	2:
																				tipoCargamento	=	TipoCarga.TECNOLOGIA;
																				codigoTarifa	=	'T';
																				break;
																case	3:
																				tipoCargamento	=	TipoCarga.AUTOS;
																				codigoTarifa	=	'V';
																				break;
																case	4:
																				tipoCargamento	=	TipoCarga.CARGAS_PESADAS;
																				codigoTarifa	=	'P';
																				break;
																case	5:
																				tipoCargamento	=	TipoCarga.CONTENEDORES;
																				codigoTarifa	=	'K';
																				break;
																default:
																				System.out.println("Tipo	de	carga	no	valido");
																				tipoCargamento	=	null;
																				codigoTarifa	=	'-';
																				break;
												}
												System.out.println("Codigo	de	tarifa	asignado:	"	+	codigoTarifa);
												System.out.println("Tipo	de	cargamento:	"	+	tipoCargamento);
												//	---	Si-Sino	(if-else):	validar	rango	de	peso	del	despacho	---
												if	(pesoDespacho	>=	PESO_MIN	&&	pesoDespacho	<=	PESO_MAX)
												{
																System.out.println("Peso	dentro	del	rango	permitido,	desembarque	normal");
												}
												else
												{
																System.out.println("Peso	fuera	de	rango:	desembarque	con	precaucion	y	equipo	de	apoyo");
																contadorFueraRango++;
																banderaSobrepeso	=	true;
												}
												//	---	Acumulador	---
												pesoTotal	+=	pesoDespacho;
								}
								System.out.println("Peso	total	acumulado	de	todos	los	despachos:	"	+	pesoTotal);
								//	---	Mientras	(while):	calcular	barcazas	necesarias	segun	capacidad	---
								barcazasNecesarias	=	0;
								while	(pesoTotal	>	0)
								{
												barcazasNecesarias++;
												pesoTotal	-=	CAPACIDAD_BARCAZA;
								}
								System.out.println("Numero	de	barcazas	necesarias	para	todo	el	cargamento:	"	+	barcazasNecesarias);
								//	---	Uso	final	del	contador	y	la	bandera	---
								if	(banderaSobrepeso)
								{
												System.out.println("Se	registraron	"	+	contadorFueraRango	+	"	despachos	fuera	del	rango	de	peso	permitido");
								}
								else
								{
												System.out.println("Todos	los	despachos	estuvieron	dentro	del	rango	permitido");
								}
								teclado.close();
				}
}
