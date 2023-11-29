
public class Hash {
   int tabela[];
   int m1, m2, m, reserva;
   final int NULO = -1;

   public Hash() {
      this(13, 7);
   }

   public Hash(int m1, int m2) {
      this.m1 = m1;
      this.m2 = m2;
      this.m = m1 + m2;
      this.tabela = new int[this.m];
      for (int i = 0; i < m1; i++) {
         tabela[i] = NULO;
      }
      reserva = 0;
   }

   public int h(int elemento) {
      return elemento % m1;
   }

   public boolean inserir(int elemento) {
      boolean resp = false;
      if (elemento != NULO) {
         int pos = h(elemento);
         if (tabela[pos] == NULO) {
            tabela[pos] = elemento;
            resp = true;
         } else if (reserva < m2) {
            tabela[m1 + reserva] = elemento;
            reserva++;
            resp = true;
         }
      }
      return resp;
   }

   public boolean pesquisar(int elemento) {
      boolean resp = false;
      int pos = h(elemento);
      if (tabela[pos] == elemento) {
         resp = true;
      } else if (tabela[pos] != NULO) {
         for (int i = 0; i < reserva; i++) {
            if (tabela[m1 + i] == elemento) {
               resp = true;
               i = reserva;
            }
         }
      }
      return resp;
   }

   boolean remover(int elemento) {
        boolean resp = false;
        int pos = h(elemento);
        
        if (tabela[pos] == elemento) { // caso o elemento a remover esteja na TABELA
            tabela[pos] = NULO;
            resp = true;
            // se tiver algum elemento na mesma posção da reserva, leva ele pra tabela
            for(int i = 0; i < reserva; i++) {
                if(h(tabela[m1 + i]) == pos) {
                    tabela[pos] = tabela[m1 + i];
                    tabela[m1 + i] = NULO;
                    i = reserva;
                }            
            }
        } else if (tabela[pos] != NULO) { // caso o elemento a remover esteja na RESERVA
            for (int i = 0; i < reserva; i++) { // percorre reserva
                if (tabela[m1 + i] == elemento) { // se o elemento estiver na reserva
                    // poe o ultimo num. da resrva no lugar vazio (a ordem das tabelas na reserva não importa)
                    tabela[m1 + i] = tabela[reserva - 1];
                    tabela[reserva - 1] = NULO;
                    resp = true;
                    i = reserva;
                }
            }
        }
        return resp;
   }
}