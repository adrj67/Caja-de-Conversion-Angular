
package entidad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Prueba2 extends JFrame {
    private JTextField txtFichasDelCargo; // JFormattedTextField
    private JTextField txtDevolucionFueraDelCargo; 
    private JTextField txtPagadasPorCajaDePublico;
    private JTextField txtProvenientesDeCajaEmpleados;
    private JTextField txtTotalBeneficio;
    private JTextField txtTotalQuebranto;
    private JTextField txtVentaFichas;
    
    private JButton btnCalcular;
    private JButton btnLimpiar;
    
    private JLabel lblTotalPago;
    private JLabel lblBeneficio;
    private JLabel lblPoderPublico;
    private JLabel lblRescateMayorPago;
    boolean rescateMayorPago;
    private JLabel lblFichasPremiadasIngresos;
    private JLabel lblFichasAPagarIngresos;
    private JLabel lblFichasPremiadasEgresos;
    private JLabel lblFichasAPagarEgresos;

    public Prueba2() throws ParseException {
        setTitle("Caja de Conversion");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        placeComponents(panel);

        setVisible(true);
        this.setLocationRelativeTo(null); // centrar
    }

    private void placeComponents(JPanel panel) throws ParseException {
        panel.setLayout(null);

        // Campos de texto y etiquetas para cada valor
        // fichasDelCargo
        JLabel lblFichasDelCargo = new JLabel("Fichas del Cargo:");
        lblFichasDelCargo.setBounds(10, 20, 120, 25); // izq - arriba - der - abajo
        panel.add(lblFichasDelCargo);

        txtFichasDelCargo = new JTextField (25); // new JFormattedTextField(formatoMoneda);
        txtFichasDelCargo.setBounds(190, 20, 165, 25);
        txtFichasDelCargo.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(txtFichasDelCargo);
        
        // devolucionFueraDelCargo
        JLabel lblDevolucionFueraDelCargo = new JLabel("Devolucion Fuera Del Cargo:");
        lblDevolucionFueraDelCargo.setBounds(10, 50, 220, 25);
        panel.add(lblDevolucionFueraDelCargo);

        
        txtDevolucionFueraDelCargo = new JTextField (25) ;
        txtDevolucionFueraDelCargo.setBounds(190, 50, 165, 25);
        txtDevolucionFueraDelCargo.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(txtDevolucionFueraDelCargo);
        
        // pagadasPorCajaDePublico
        JLabel lblPagadasPorCajaDePublico = new JLabel("Pagadas por Caja de Publico:");
        lblPagadasPorCajaDePublico.setBounds(10, 80, 220, 25);
        panel.add(lblPagadasPorCajaDePublico);

        txtPagadasPorCajaDePublico = new JTextField (25) ;
        txtPagadasPorCajaDePublico.setBounds(190, 80, 165, 25);
        txtPagadasPorCajaDePublico.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(txtPagadasPorCajaDePublico);
        
        // provenientesDeCajaEmpleados
        JLabel lblProvenientesDeCajaEmpleados = new JLabel("Prov. de Caja de Empleados:");
        lblProvenientesDeCajaEmpleados.setBounds(10, 110, 220, 25);
        panel.add(lblProvenientesDeCajaEmpleados);

        txtProvenientesDeCajaEmpleados = new JTextField (25) ;
        txtProvenientesDeCajaEmpleados.setBounds(190, 110, 165, 25);
        txtProvenientesDeCajaEmpleados.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(txtProvenientesDeCajaEmpleados);
        
        // Total Pago
        lblTotalPago = new JLabel("");
        lblTotalPago.setBounds(190, 140, 220, 25);
        panel.add(lblTotalPago);

        // totalBeneficio
        JLabel lblTotalBeneficio = new JLabel("Total Beneficio:");
        lblTotalBeneficio.setBounds(10, 170, 220, 25);
        panel.add(lblTotalBeneficio);

        txtTotalBeneficio = new JTextField (25) ;
        txtTotalBeneficio.setBounds(190, 170, 165, 25);
        txtTotalBeneficio.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(txtTotalBeneficio);
        
        // totalQuebranto
        JLabel lblTotalQuebranto = new JLabel("Total Quebranto:");
        lblTotalQuebranto.setBounds(10, 200, 220, 25);
        panel.add(lblTotalQuebranto);

        txtTotalQuebranto = new JTextField (25) ;
        txtTotalQuebranto.setBounds(190, 200, 165, 25);
        txtTotalQuebranto.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(txtTotalQuebranto);
        
        // Beneficio Real
        lblBeneficio = new JLabel("");
        lblBeneficio.setBounds(190, 230, 220, 25);
        panel.add(lblBeneficio);
        
        // Venta Fichas en pesos y dolares
        JLabel lblVentaFichas = new JLabel("Venta Fichas $ y U$s:");
        lblVentaFichas.setBounds(10, 260, 220, 25);
        panel.add(lblVentaFichas);

        txtVentaFichas = new JTextField (25) ;
        txtVentaFichas.setBounds(190, 260, 165, 25);
        txtVentaFichas.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(txtVentaFichas);
        
        // Poder del Publico
        lblPoderPublico = new JLabel("");
        lblPoderPublico.setBounds(190, 290, 220, 25);
        panel.add(lblPoderPublico);
        
        // Rescate Mayor al Pago?
        lblRescateMayorPago = new JLabel("");
        lblRescateMayorPago.setBounds(190, 310, 500, 25);
        panel.add(lblRescateMayorPago);
        
        // Fichas Premiadas INGRESOS
        lblFichasPremiadasIngresos = new JLabel("");
        lblFichasPremiadasIngresos.setBounds(450, 80, 500, 25);
        panel.add(lblFichasPremiadasIngresos);
        
        // Fichas a Pagar INGRESOS
        lblFichasAPagarIngresos = new JLabel("");
        lblFichasAPagarIngresos.setBounds(450, 110, 500, 25);
        panel.add(lblFichasAPagarIngresos);
        
        // Fichas Premiadas EGRESOS
        lblFichasPremiadasEgresos = new JLabel("");
        lblFichasPremiadasEgresos.setBounds(450, 170, 500, 25);
        panel.add(lblFichasPremiadasEgresos);
        
        // Fichas a Pagar EGRESOS
        lblFichasAPagarEgresos = new JLabel("");
        lblFichasAPagarEgresos.setBounds(450, 200, 500, 25);
        panel.add(lblFichasAPagarEgresos);
        
        // BOTONES
        // Boton Calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(250, 400, 95, 25);
        panel.add(btnCalcular);
        
        // Boton Limpiar
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(500, 400, 95, 25);
        panel.add(btnLimpiar);


        btnLimpiar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Limpiar campos de texto
          txtFichasDelCargo.setText("");
          txtDevolucionFueraDelCargo.setText("");
          txtPagadasPorCajaDePublico.setText("");
          txtProvenientesDeCajaEmpleados.setText("");
          txtTotalBeneficio.setText("");
          txtTotalQuebranto.setText("");
          txtVentaFichas.setText("");

          // Limpiar etiquetas de resultado
          lblTotalPago.setText("");
          lblBeneficio.setText("");
          lblPoderPublico.setText("");
          lblRescateMayorPago.setText("");
          lblFichasPremiadasIngresos.setText("");
          lblFichasAPagarIngresos.setText("");
          lblFichasPremiadasEgresos.setText("");
          lblFichasAPagarEgresos.setText("");
    }
        });
    
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try{
                
                // Aquí va la lógica de cálculo
                // Tomo los valores del formulario
                String textoPagadasPorCajaDePublico = txtPagadasPorCajaDePublico.getText();
                String textoProvenientesDeCajaEmpleados = txtProvenientesDeCajaEmpleados.getText();
                float pagadasPorCajaDePublico = !textoPagadasPorCajaDePublico.isEmpty() ? Float.parseFloat(textoPagadasPorCajaDePublico) : 0;
                float provenientesDeCajaEmpleados = !textoProvenientesDeCajaEmpleados.isEmpty() ? Float.parseFloat(textoProvenientesDeCajaEmpleados) : 0;
                
                String textoTotalBeneficio = txtTotalBeneficio.getText();
                String textoTotalQuebranto = txtTotalQuebranto.getText();
                float totalBeneficio = !textoTotalBeneficio.isEmpty() ? Float.parseFloat(textoTotalBeneficio) : 0;
                float totalQuebranto = !textoTotalQuebranto.isEmpty() ? Float.parseFloat(textoTotalQuebranto) : 0;
                
                String textoVentaFichas = txtVentaFichas.getText();
                float ventaFichas = !textoVentaFichas.isEmpty() ? Float.parseFloat(textoVentaFichas) : 0;

                String textoFichasDelCargo = txtFichasDelCargo.getText();
                float fichasDelCargo = !textoFichasDelCargo.isEmpty() ? Float.parseFloat(textoFichasDelCargo) : 0;
                
                String textoDevolucionFueraDelCargo = txtDevolucionFueraDelCargo.getText();
                float devolucionFueraDelCargo = !textoDevolucionFueraDelCargo.isEmpty() ? Float.parseFloat(textoDevolucionFueraDelCargo) : 0;
                
                
                // Realiza los cálculos necesarios - calcular totalPago
                float totalPago = pagadasPorCajaDePublico + provenientesDeCajaEmpleados;
                
                float beneficio = totalBeneficio - totalQuebranto;
                
                float poderPublico = ventaFichas-totalPago-beneficio-fichasDelCargo+devolucionFueraDelCargo;
                
                float fichasPremiadasIngresos = 0;
                float fichasAPagarIngresos = 0;
                float fichasPremiadasEgresos = 0;
                float fichasAPagarEgresos = 0;
                if(pagadasPorCajaDePublico < (poderPublico*-1)){
                  rescateMayorPago = true;
                  fichasPremiadasIngresos = (poderPublico *-1) + devolucionFueraDelCargo;
                  fichasAPagarIngresos = pagadasPorCajaDePublico;
                  fichasPremiadasEgresos = pagadasPorCajaDePublico;
                  fichasAPagarEgresos = pagadasPorCajaDePublico + (poderPublico *-1) + devolucionFueraDelCargo;
                } else {
                  rescateMayorPago = false;
                   fichasPremiadasIngresos = 0;
                   fichasAPagarIngresos = pagadasPorCajaDePublico + poderPublico - devolucionFueraDelCargo ;
                   fichasPremiadasEgresos = pagadasPorCajaDePublico + poderPublico - devolucionFueraDelCargo;
                   fichasAPagarEgresos = pagadasPorCajaDePublico;
                };
                String textoRescateMayorPago = rescateMayorPago ? "<html><h2><font color='red'>Atención, RESCATE MAYOR AL PAGO!!</font></h2></html>" : "<html><font color='blue'>NO hay rescate mayor al pago.</font></html>";
                
                // Actualiza las etiquetas con los resultados
                lblTotalPago.setText("Total Pago: $ " + totalPago);
                
                lblBeneficio.setText("BENEFICIO: $ " + beneficio);
                
                lblPoderPublico.setText("Poder del Publico: $ " + poderPublico);
                
                lblRescateMayorPago.setText("" + textoRescateMayorPago);
                
                lblFichasPremiadasIngresos.setText("INGRESOS - Fichas Premiadas: $" + fichasPremiadasIngresos);
                
                lblFichasAPagarIngresos.setText("INGRESOS - Fichas a Pagar: $" + fichasAPagarIngresos);
                
                lblFichasPremiadasEgresos.setText("EGRESOS - Fichas Premiadas: $" + fichasPremiadasEgresos);
                
                lblFichasAPagarEgresos.setText("EGRESOS - Fichas a Pagar: $" + fichasAPagarEgresos);
              } catch(NumberFormatException ex){
                System.err.println("Error al convertir texto a número: " + ex.getMessage());
              }
    
            }
            
            
        });
    }
    
    public static void main(String[] args) throws ParseException {
        new Prueba2();
    }
}
