while True:
    try:
        edad = int(input("que edad tienes?"))

        if edad >= 18:
            print("eres mayor de edad ya puedes votar")
        else:
            print("eres menor de edad todavia no puedes votar")

        if edad >= 16:
            print("ya tienes edad para conducir")

            licencia = input("tienes licencia de conducir? (si/no):").lower()

            if licencia == "si":
                print("puedes conducir")
            elif licencia == "no":
                print("no puedes conducir, ve a la autoescuela")

        break

    except ValueError:
        print("!Erorr¡por favor, ingresa un numero valido")
