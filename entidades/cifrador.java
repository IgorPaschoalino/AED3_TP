package entidades;


public class cifrador {
   
   public static byte[] cifrar(byte[] dados, String chave) { // cifra os dados com a chave iniciando pela cifra de Vigenere e depois a cifra de coluna
      byte[] dadosCifrados = new byte[dados.length];
      dadosCifrados = cifraDeVigenere(dados, chave);
      dadosCifrados = cifraDeColuna(dadosCifrados, chave);
      return dadosCifrados;
   }
   
   public static byte[] decifrar(byte[] dados, String chave) { // decifra os dados com a chave iniciando pela decifra de coluna e depois a decifra de Vigenere
      byte[] dadosDecifrados = new byte[dados.length];
      dadosDecifrados = decifraDeColuna(dados, chave);
      dadosDecifrados = decifraDeVigenere(dadosDecifrados, chave);
      return dadosDecifrados;
   }

   public static byte[] cifraDeVigenere(byte[] dados, String chave) { // cifra de Vigenere, por meio da soma de valores dos bytes dos dados com os bytes da chave
      byte[] dadosCifrados = new byte[dados.length];
      byte[] chaveBytes = chave.getBytes();
      for (int i = 0; i < dados.length; i++) dadosCifrados[i] = (byte) ((  dados[i] + chaveBytes[i % chaveBytes.length]) % 256);
      return dadosCifrados;
   }

   public static byte[] decifraDeVigenere(byte[] dados, String chave) { // decifra de Vigenere, por meio da subtração de valores dos bytes dos dados com os bytes da chave
      byte[] dadosDecifrados = new byte[dados.length];
      byte[] chaveBytes = chave.getBytes();
      for (int i = 0; i < dados.length; i++) dadosDecifrados[i] = (byte) ((dados[i] - chaveBytes[i % chaveBytes.length]) % 256);
      return dadosDecifrados;
   }

   public static byte[] cifraDeColuna(byte[] dados, String chave) { // cifra de coluna, por meio da reorganização dos bytes dos dados de acordo com a chave, vindos de uma matriz.
      byte[] dadosCifrados = new byte[dados.length];
      int[] ordem = new int[chave.length()];
      char[] chaveTemp = chave.toCharArray();
      double tamanhoDados = dados.length;
      double tamanhoChave = chave.length();
      int menor;
      int count = 0;
      
      
      
      for(int i = 0; i < chaveTemp.length; i++) { // método para retornar o indice das posições da chave em ordem crescente, chave = CABO -> ordem = 1203
         menor = -1;
         for(int j = 0; j < chaveTemp.length; j++) {
             if(chaveTemp[j] != '-' && (menor == -1 || chave.charAt(menor) < chaveTemp[j])) {
                 menor = j;
             }
         }
         ordem[count] = menor;
         chaveTemp[menor] = '-';
         count++;
     }

     int pos = 0;
     count = 0;
     for(int i = 0; i < chave.length(); i++) { // método para reorganizar os bytes dos dados de acordo com a ordem da chave, por meio da função criaada por Igor Paschoalino
         for(int j = 0; j < (Math.ceil(tamanhoDados / tamanhoChave)); j++) {
            pos = (j * chave.length()) + ordem[i]; // essa é a função que reorganiza os bytes
            if (pos < dados.length) {
               dadosCifrados[count] = dados[pos];
               count++;
            }
         }
      }

      return dadosCifrados;
   }

   public static byte[] decifraDeColuna(byte[] dados, String chave) { // decifra de coluna, por meio da reorganização dos bytes dos dados de acordo com a chave, vindos de uma matriz.
      byte[] dadosDecifrados = new byte[dados.length];
      int[] ordem = new int[chave.length()];
      char[] chaveTemp = chave.toCharArray();
      double tamanhoDados = dados.length;
      double tamanhoChave = chave.length();
      int menor;
      int count = 0;
      
      
      
      for(int i = 0; i < chaveTemp.length; i++) {
         menor = -1;
         for(int j = 0; j < chaveTemp.length; j++) {
             if(chaveTemp[j] != '-' && (menor == -1 || chave.charAt(menor) < chaveTemp[j])) {
                 menor = j;
             }
         }
         ordem[count] = menor;
         chaveTemp[menor] = '-';
         count++;
     }

     int pos = 0;
     count = 0;
     for(int i = 0; i < chave.length(); i++) { 
         for(int j = 0; j < (Math.ceil(tamanhoDados / tamanhoChave)); j++) {
            pos = (j * chave.length()) + ordem[i]; // função que reorganiza os bytes
            if (pos < dados.length) {
               dadosDecifrados[pos] = dados[count]; // inverso do cifrador, reorganiza os bytes de acordo com a ordem da chave
               count++;
            }
         }
      }

      return dadosDecifrados;
   }


}
