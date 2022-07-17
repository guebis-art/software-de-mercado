package main;

import modelo.Produto;
import utills.Utills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Mercado {
    public static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto>produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu(){

        System.out.println("---------------------------------------------------");
        System.out.println("--------------Bem-vindo ao Mercado Econ------------");
        System.out.println("---------------------------------------------------");
        System.out.println("----Selecione uma operacao que deseja realizar------");
        System.out.println("----------------------------------------------------");
        System.out.println("| Opçao 1- Cadastrar  |");
        System.out.println("| Opçao 2- Listar     |");
        System.out.println("| Opçao 3- Comprar    |");
        System.out.println("| Opçao 4- Carrinho   |");
        System.out.println("| Opçao 5- Sair       |");

        int opcao = input.nextInt();
        switch (opcao){

            case 1:cadastrarProdutos();
            break;
            case 2: listarProdutos();
            break;
            case 3: comprarProdutos();
            break;
            case 4: verCarrinho();
            break;
            case 5:
                System.out.println("-- Obrigado pela preferencia! --");
                System.exit( 0);

            default:
                System.out.println("Opcao Invalida!");
                menu();
                break;

        }

    }
    private static void cadastrarProdutos(){
        System.out.println("Nome do prodduto: ");
        String nome = input.next();

        System.out.println("Preço de produtos: ");
        double precos = input.nextDouble();


       Produto produto = new Produto(nome, precos);
        produtos.add(produto);

        System.out.println(produto.getNome() + " Foi cadastrado com sucesso!!");
        menu();

    }
    private static void listarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Lista de produtos! ");


            for (Produto p : produtos) {
                System.out.println(p);

            }

        } else {
            System.out.println(" Nenhum produto cadastrado ");
        }
        menu();
    }
        private static void comprarProdutos() {
            if (produtos.size() > 0) {
                System.out.println("Codigo do produto \n");
                System.out.println("----------------produtos disponiveis--------------------");

            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }
            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p);

                        carrinho.put(p, qtd +1);

                    } catch (NullPointerException e) {

                        carrinho.put(p,1);
                    }
                    System.out.println(p.getNome() + "  adicionado ao carrinho");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produtoao carinho? ");
                        System.out.println("Digite 1 para sim, ou 0 para finalizar a compra");
                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProdutos();
                        } else {

                            finalizarCompras();
                        }
                    }
                } else {

                    System.out.println("Produtos nao encontrados");
                    menu();
                }

            }

        } else{
                System.out.println("Nao existe produto cadastrado");
                menu();
            }
    }

     private static void verCarrinho() {

         System.out.println("---- Produtos no seu carrinho! -----");
         if(carrinho.size() > 0){
             for(Produto p: carrinho.keySet()){
                 System.out.println("Produto: " + p + "\nQuantidade " + carrinho.get(p));
             }
         }else{
             System.out.println("Carrinho vazio!");
         }
         menu();
     }
     private static void finalizarCompras(){

        Double valorDaCompra = 0.0;
         System.out.println("Seus produtos!");

         for(Produto p : carrinho.keySet()){
             int qtd = carrinho.get(p);
             valorDaCompra += p.getPreco() * qtd;
             System.out.println(p);
             System.out.println("Quantidade: " + qtd);
             System.out.println("----------------------");
         }
         System.out.println("O valor da sua compra e: " + Utills.doubleToString(valorDaCompra));
         carrinho.clear();
         System.out.println("Obrigado pela preferencia!");
         menu();
     }


}


