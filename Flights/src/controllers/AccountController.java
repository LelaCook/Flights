<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TableColumn?>
<?import javafx.scene.control.TableView?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.ColumnConstraints?>
<?import javafx.scene.layout.GridPane?>
<?import javafx.scene.layout.RowConstraints?>
<?import javafx.scene.layout.StackPane?>
<?import javafx.scene.text.Font?>

<StackPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" style="-fx-background-color: powderblue;" xmlns="http://javafx.com/javafx/19" xmlns:fx="http://javafx.com/fxml/1" fx:controller="controllers.AccountController">
   <children>
      <GridPane hgap="10.0" vgap="10.0">
        <columnConstraints>
          <ColumnConstraints halignment="RIGHT" hgrow="ALWAYS" maxWidth="92.79998779296875" minWidth="10.0" prefWidth="64.79998779296875" />
            <ColumnConstraints hgrow="SOMETIMES" maxWidth="439.2000122070312" minWidth="10.0" prefWidth="430.40001220703124" />
          <ColumnConstraints halignment="RIGHT" hgrow="ALWAYS" maxWidth="353.20001220703125" minWidth="10.0" prefWidth="63.599975585937614" />
        </columnConstraints>
        <rowConstraints>
          <RowConstraints maxHeight="95.60001220703126" minHeight="0.0" prefHeight="40.60001831054687" vgrow="SOMETIMES" />
          <RowConstraints maxHeight="304.600023651123" minHeight="10.0" prefHeight="275.79998168945315" vgrow="SOMETIMES" />
          <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
        </rowConstraints>
         <children>
            <Button fx:id="logoutButton" mnemonicParsing="false" onAction="#logOut" prefHeight="26.0" prefWidth="67.0" text="Log Out" GridPane.columnIndex="2">
               <font>
                  <Font name="Book Antiqua" size="12.0" />
               </font>
            </Button>
            <Button fx:id="backButton" mnemonicParsing="false" onAction="#back" prefHeight="42.0" prefWidth="64.0" text="Back to Search" textAlignment="CENTER" wrapText="true">
               <font>
                  <Font name="Book Antiqua" size="12.0" />
               </font>
            </Button>
            <GridPane hgap="5.0" GridPane.columnIndex="1" GridPane.rowIndex="2">
              <columnConstraints>
                  <ColumnConstraints hgrow="SOMETIMES" maxWidth="137.600048828125" minWidth="10.0" prefWidth="63.400000000000006" />
                <ColumnConstraints hgrow="SOMETIMES" maxWidth="103.20001220703125" minWidth="10.0" prefWidth="93.8" />
                  <ColumnConstraints hgrow="SOMETIMES" maxWidth="108.60005187988281" minWidth="10.0" prefWidth="108.60005187988281" />
                  <ColumnConstraints hgrow="SOMETIMES" maxWidth="85.39996337890625" minWidth="10.0" prefWidth="57.39994812011719" />
                <ColumnConstraints hgrow="SOMETIMES" maxWidth="106.20001220703125" minWidth="10.0" prefWidth="106.20001220703125" />
              </columnConstraints>
              <rowConstraints>
                <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
              </rowConstraints>
               <children>
                  <Label prefHeight="18.0" prefWidth="98.0" text="Delete Flight:" GridPane.columnIndex="1">
                     <font>
                        <Font name="Book Antiqua" size="14.0" />
                     </font>
                  </Label>
                  <Button fx:id="deleteButton" mnemonicParsing="false" onAction="#delete" text="Enter" GridPane.columnIndex="3">
                     <font>
                        <Font name="Book Antiqua" size="12.0" />
                     </font>
                  </Button>
                  <TextField fx:id="flightId" promptText="Flight ID" GridPane.columnIndex="2" />
               </children>
            </GridPane>
            <Label text="Your Flights" translateX="110.0" GridPane.columnIndex="1">
               <font>
                  <Font name="Book Antiqua Bold" size="36.0" />
               </font>
            </Label>
            <TableView fx:id="yourFlight" prefHeight="200.0" prefWidth="200.0" GridPane.columnIndex="1" GridPane.rowIndex="1">
              <columns>
                <TableColumn prefWidth="75.0" text="C1" />
                <TableColumn prefWidth="75.0" text="C2" />
              </columns>
            </TableView>
            <Button fx:id="refreshButton" mnemonicParsing="false" onAction="#refresh" prefHeight="26.0" prefWidth="63.0" text="Refresh" GridPane.columnIndex="2" GridPane.rowIndex="1">
               <font>
                  <Font name="Book Antiqua" size="12.0" />
               </font>
            </Button>
         </children>
         <StackPane.margin>
            <Insets />
         </StackPane.margin>
         <padding>
            <Insets bottom="10.0" left="10.0" right="10.0" top="10.0" />
         </padding>
      </GridPane>
   </children>
</StackPane>
