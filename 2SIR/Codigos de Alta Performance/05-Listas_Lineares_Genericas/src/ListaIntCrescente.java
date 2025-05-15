public class ListaIntCrescente {

    private class NO {
        int dado;
        NO proximo;

        public NO(int dado) {
            this.dado = dado;
        }
    }

    private NO lista = null;

    public void mostra() {
        System.out.println("*************** Lista ***************");

        NO aux = this.lista;

        while (aux != null) {
            System.out.print(aux.dado + "\n");

            aux = aux.proximo;
        }
        System.out.println("*************************************");
    }

    public void insere(int dado) {
        NO novo = new NO(dado);

        if (lista == null) {
            novo.proximo = null;

            lista = novo;
        } else if (novo.dado < lista.dado) {
            novo.proximo = lista;

            lista = novo;
        } else {
            NO aux = lista;

            boolean encontrado = false;

            while (aux.proximo != null && !encontrado) {
                if (aux.proximo.dado < novo.dado)
                    aux = aux.proximo;
                else
                    encontrado = true;
            }
            novo.proximo = aux.proximo;

            aux.proximo = novo;
        }
    }

    public void remover(int dado) {
        NO aux = lista;
    }
}