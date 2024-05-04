import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.service.ProductService;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SimpleTUI {
    private static ProductService productService; // Assuming this is set up elsewhere

    public static void main(String[] args) throws SQLException {
        productService = new ProductService();

        Terminal terminal = null;
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.startScreen();

            final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
            final Window window = new BasicWindow("Product List");
            Panel contentPanel = new Panel(new GridLayout(1));

            List<Product> products = productService.retrieveAllProducts();

            for (Product product : products) {
                contentPanel.addComponent(new Label(product.getName() + " - $" + product.getPrice()));
            }

            window.setComponent(contentPanel);
            textGUI.addWindowAndWait(window);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (terminal != null) {
                try {
                    terminal.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
