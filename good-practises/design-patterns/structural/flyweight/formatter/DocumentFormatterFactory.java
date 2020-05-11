package structural.flyweight.formatter;

import java.util.HashMap;
import java.util.Map;

public class DocumentFormatterFactory {

    private static Map<DocumentFormatter.Type, DocumentFormatter> formatters = new HashMap<>();

    public static DocumentFormatter getFormatter(DocumentFormatter.Type formatterType) {
        DocumentFormatter formatter = formatters.get(formatterType);

        if(formatter == null) {
            formatters.put(formatterType, formatterType.getSupplier().get());
        }

        return formatters.get(formatterType);
    }

}
