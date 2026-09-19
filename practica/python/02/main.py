# Solucion del ejercicio

# 1 pedir nombre y guardar en variable 'nombre'

nombre = input("Cual es tu nombre?")
print("bienvendido " + nombre)

# 2 pedir edad y guardar en variable 'edad_texto'

edad_texto = input("Cual es tu edad?")
print("tu edad es " + edad_texto + ", tienes permitido el ingreo")

# 3 convertir edad a int y guardar en variable 'edad_numero'
edad_numero = int(edad_texto)

# resultados
print(f"y ahora te vamos a guardar en el sistema como: {nombre}")
print(f"""y en 5 años mas cuando tengas {edad_numero + 5} años ven para
actualizar el sistema""")
