# TP4--AEDS3 (Igor Paschoalino / Rafel Clarks)
## Métodos Implementados/Alterados
### Criado um arquivo cifrador para fazer as cifragens

* Case
Foram adicionados um arquivo cifrador com método cifrar e decifrar, possuindo seus devidos métodos dentro dele

* Método cifrar()
Esse método chama dois outros métodos diferentes para fazer o ciframento dos dados, sendo deles o método de ciframento vigenere e colunas
* Método decifrar()
Esse método chama dois outros métodos diferentes para fazer o deciframento dos dados, sendo deles o método de deciframento para vigenere e colunas
* Método cifraDeVigenere()
Este método faz uso da cifra de vigenere ensinada em sala para cifrar os dados antes de adcionar no arquivo, ela utiliza de uma chave para mudar dos dados origem, por meio de somas
* Método decifraDeVigener()
Este método recebe dados cifrados pela cifra de vigenere e sua chave, utilizando da chave para fazer subtrações em consecuitivas e retonar ao dado original
* Método cifraDeColuna()
Este método faz uso da cifra de colunas ensinada em sala de aula para cifrar os dados ja cifrados pela função cifraDeVigenere, ela utiliza de uma formula matemática criada por Igor Paschoalino para realizar o ciframento ((i * chave.lenght) + ordem)
Método decifraDeColuna()
Este método repete o sistema de ciframento de colunas, porém invertendo a forma em que ela é adcionada ao array final, decifrando os dados pelo meio inverso em que ele é cifrado.

### Opinião do grupo

Todos os objetivos foram alcançados, o grupo aprendeu e se divertiu bastante ao fazer o tp4, foram notadas dificuldades na implementação da cifra de colunas em relação a de vigenere (possivel notar pelo tamanho das funções), mas foi extramemente gratificante vê-la funcionando. parte da dificuldade foi desenvolver a forma em que a chave é transformada em um array com os indices da ordem alfabética (CABO -> 2103 -> 1203), visto que era necessaria para a função desenvolvida funcionar

# CHECKLIST

* Há uma função de cifragem em todas as classes de entidades, envolvendo pelo menos duas operações diferentes e usando uma chave criptográfica?
* Uma das operações de cifragem é baseada na substituição e a outra na transposição? SIM
* O trabalho está funcionando corretamente? SIM
* O trabalho está completo? SIM
* O trabalho é original e não a cópia de um trabalho de um colega? SIM