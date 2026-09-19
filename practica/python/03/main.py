# Solucion del mini proyecto

# 1 solocitar valores

nombre = input("Cual es tu nombre? ")
edad = int(input("Cual es tu edad? "))
ciudad = input("Cual es tu ciudad? ")
horas_comp_dia = float(input("Horas que usas el computador al día: "))
horas_estudio_semana = float(input("Horas que dedicas al estudio por semana: "))

# 2. Cálculos
horas_comp_semana = horas_comp_dia * 7
total_horas = horas_comp_semana + horas_estudio_semana
cuadrado_estudio = horas_estudio_semana**2
residuo_edad = edad % 2  # Operador % para residuo

# 3. Variables booleanas
usa_frecuente = horas_comp_dia >= 2
habito_estudio = horas_estudio_semana >= 10
potencial_ds = habito_estudio and usa_frecuente

# 4. Texto
mensaje = f"Hola {nombre}, tienes {edad} años y vives en {ciudad}."
print(mensaje)
print(f"Nombre en MAYÚSCULAS: {nombre.upper()}")
print(f"Nombre en minúsculas: {nombre.lower()}")

# 5. Reporte
print("\n" + "=" * 40)
print("REPORTE DEL ASPIRANTE")
print("=" * 40)
print(f"Nombre: {nombre}")
print(f"Ciudad: {ciudad}")
print(f"\nHoras de computador por semana: {horas_comp_semana}")
print(f"Horas de estudio por semana: {horas_estudio_semana}")
print(f"Total de horas: {total_horas}")
print(f"\nUsa frecuentemente el computador: {usa_frecuente}")
print(f"Tiene hábito de estudio: {habito_estudio}")
print(f"\nPerfil con potencial para Ciencia de Datos: {potencial_ds}")
