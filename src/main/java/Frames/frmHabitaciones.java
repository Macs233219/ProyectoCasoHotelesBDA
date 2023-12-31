
package Frames;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;


/**
 * Clase donde se mostrarán las habitaciones registradas.
 * @author Canché Sastré Marlon Alejandro
 * @author Sánchez Rentería Juan Diego
 */
public class frmHabitaciones extends javax.swing.JFrame {

    MongoClient mongoClient = new MongoClient("localhost",27017);
    MongoDatabase database = mongoClient.getDatabase("hotel_proyecto");
    MongoCollection<Document> habitacionCollection = database.getCollection("habitacion");
    MongoCollection<Document> tarifaCollection = database.getCollection("tarifa");
    ArrayList<String> habitaciones;
    String hotelSeleccionado;
    String habitacionSeleccionada;
    
   
    
    /**
     * Método constructor de la clase.
     */
    public frmHabitaciones() {
        this.habitaciones = new ArrayList<>();
        initComponents();
//        this.insertar();
//        this.mostrar();
    }
    
    /**
     * Método para insertar datos referentes a las habitaciones.
     */
    private void insertar() {
//        Document habitacion = new Document("_id", "1")
//                .append("tipo", "Suite")
//                .append("identificador", "AC90")
//                .append("idHotel", "1");
//        
//        habitacionCollection.insertOne(habitacion);
        
        Document tarifa1 = new Document("_id", "1")
                .append("idHabitacion", "1")
                .append("temporada", "Baja")
                .append("precio", 5000.50);
        
        Document tarifa2 = new Document("_id", "2")
                .append("idHabitacion", "2")
                .append("temporada", "Baja")
                .append("precio", 4000.40);
        
        Document tarifa3 = new Document("_id", "3")
                .append("idHabitacion", "3")
                .append("temporada", "Baja")
                .append("precio", 3000.30);
        
        Document tarifa4 = new Document("_id", "4")
                .append("idHabitacion", "4")
                .append("temporada", "Baja")
                .append("precio", 2000.20);
        
        Document tarifa5 = new Document("_id", "5")
                .append("idHabitacion", "5")
                .append("temporada", "Baja")
                .append("precio", 1000.10);
        
        tarifaCollection.insertOne(tarifa1);
        tarifaCollection.insertOne(tarifa2);
        tarifaCollection.insertOne(tarifa3);
        tarifaCollection.insertOne(tarifa4);
        tarifaCollection.insertOne(tarifa5);
        
        
    }
    
    /**
     * Método para mostrar los datos de las habitaciones registradas.
     */
    public void mostrar() {
        MongoCursor<Document> cursor = habitacionCollection.find(eq("idHotel", this.hotelSeleccionado)).iterator();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número");
        model.addColumn("Clase");
        model.addColumn("Tarifa");
        
        while(cursor.hasNext()) {
            Document hab = cursor.next();
            Document tar = tarifaCollection.find(eq("idHabitacion", hab.getString("_id"))).first();

            model.addRow(new Object[]
            {
                hab.getString("identificador"),
                hab.getString("tipo"),
                tar.getDouble("precio")
            });
            tblHabitaciones.setModel(model);
            
            this.habitaciones.add(hab.getString("_id"));
        }
    }

    /**
     * Método para establecer el hotel que se haya seleccionado previamente.
     * @param hotelSeleccionado Cadena con el nombre del hotel seleccionado.
     */
    public void setHotelSeleccionado(String hotelSeleccionado) {
        this.hotelSeleccionado = hotelSeleccionado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHabitaciones = new javax.swing.JTable();
        btnReservarHabitacion = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Habitaciones");

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Habitaciones");

        tblHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHabitaciones);

        btnReservarHabitacion.setBackground(new java.awt.Color(255, 255, 204));
        btnReservarHabitacion.setText("Reservar");
        btnReservarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarHabitacionActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 255, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(354, 354, 354))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnReservarHabitacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 624, Short.MAX_VALUE)
                                .addComponent(btnVolver)))
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReservarHabitacion)
                        .addGap(35, 35, 35))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 15, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón para redireccionar a la pantalla de reservas.
     * @param evt Evento que accionó el botón.
     */
    private void btnReservarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarHabitacionActionPerformed
        // TODO add your handling code here:
        System.out.println("RESERVA PARA HOTEL: " + this.hotelSeleccionado);
        System.out.println("RESERVA PARA HABITACIÓN: " + this.habitacionSeleccionada);
        if (!"".equals(this.habitacionSeleccionada)) {
            frmReservacion newFrm = new frmReservacion();
            newFrm.setHotelSeleccionado(hotelSeleccionado);
            newFrm.setHabitacionSeleccionada(habitacionSeleccionada);
            newFrm.mostrar();
            newFrm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnReservarHabitacionActionPerformed

    /**
     * Botón para volver a la pantalla anterior.
     * @param evt Evento que accionó el botón.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        frmHoteles newFrm = new frmHoteles();
        newFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Este método identifica el hotel seleccionado
     * @param evt Evento de selección en la tabla
     */
    private void tblHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHabitacionesMouseClicked
        // TODO add your handling code here:
        int row = this.tblHabitaciones.getSelectedRow();
        this.habitacionSeleccionada = this.habitaciones.get(row);
        System.out.println(habitacionSeleccionada);
    }//GEN-LAST:event_tblHabitacionesMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservarHabitacion;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHabitaciones;
    // End of variables declaration//GEN-END:variables

}
