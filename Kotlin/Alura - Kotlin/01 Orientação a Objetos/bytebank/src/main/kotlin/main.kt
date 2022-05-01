fun main() {
    val conta1 = Conta(titular = "Bruno", numero = 123)
    val conta2 = Conta(numero = 321, titular = "Pedro")

    conta1.deposita(100.0)

    println(conta1.saldo)

    conta1.saca(50.0)

    println(conta1.saldo)

    conta1.deposita(100.0)

    println(conta1.transfere(150.0, conta2))

    println(conta1.saldo)
    println(conta2.saldo)
    
    println(conta1.transfere(150.0, conta2))
}

class Conta( var titular: String, val numero: Int) {
    var saldo = 0.0
        set(valor) {
            if(valor > 0)
                field = valor
        }

    fun deposita(valor: Double) {
        this.saldo += valor;
    }

    fun saca(valor: Double) {
        if(this.saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun transfere(valor: Double, contaDestino: Conta): Boolean {
        if(this.saldo >= valor) {
            this.saldo -= valor
            contaDestino.deposita(valor)
            return true;
        }
        return false;
    }
}

fun testaCopiasEReferencias() {
    val contaBruno = Conta("Bruno", 1000);
    contaBruno.saldo = 200.0

    val contaFran =  Conta("Fran", 1001);
    contaFran.saldo = 300.0

    println(contaBruno.titular)
    println(contaBruno.numero)
    println(contaBruno.saldo)
    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    val contaJoao = Conta("João", 1002);
    contaJoao.saldo = 305.0

    val contaMaria = contaJoao
    contaMaria.titular = "Maria"

    println(contaJoao.titular)
    println(contaMaria.titular)
}


fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> {
            println("conta é positiva")
        }
        saldo == 0.0 -> {
            println("conta é neutra")
        }
        else -> {
            println("conta é negativa")
        }
    }
}


fun testaLacos() {
    for (i in 1..3) {
        println(i)
        val titular: String = "Alex"
        val numeroConta: Int = 100 * i
        var saldo: Double = i * 25.0

        saldo += 100


        println("titular $titular")
        println("numeroConta $numeroConta")
        println("saldo $saldo")
    }

    for (i in 5 downTo 1 step 2) {
        println(i)
        if (i == 1) break
        if (i == 5) continue
        val titular: String = "Alex"
        val numeroConta: Int = 100 * i
        var saldo: Double = i * 25.0

        saldo += 100


        println("titular $titular")
        println("numeroConta $numeroConta")
        println("saldo $saldo")
    }
    var j = 0
    while (j < 3) {
        println(j)
        if (j == 1) break
        if (j == 5) continue
        val titular: String = "Alex"
        val numeroConta: Int = 100 * j
        var saldo: Double = j * 25.0

        saldo += 100

        println("titular $titular")
        println("numeroConta $numeroConta")
        println("saldo $saldo")
        j++
    }
}