package ua.com.systemgroup.dockerdatabaseserverprovider.controller;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.Client;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Invoice;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Variable;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Event;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.InvoiceArticles;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Currency;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Discount;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.DiscountItem;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.BanArticle;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Article;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.ArticlesGroup;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Barcode;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Measure;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.User;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Profile;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.ProfileEvents;
import ua.com.systemgroup.dockerdatabaseserverprovider.service.json.ImportJsonService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/import")
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ImportProviderController {

    private final ImportJsonService importJsonService;
    @Value("${custom.import.idShop}")
    private String idShop;
    @Value("${custom.import.idParentGroup}")
    private String idParentGroup;
    @Value("${custom.import.signActivity}")
    private String signActivity;
    @Value("${custom.import.idMaker}")
    private String idMaker;
    @Value("${custom.import.idDepartment}")
    private String idDepartment;
    @Value("${custom.import.dtype}")
    private String dtype;
    @Value("${custom.import.vatGroup}")
    private String vatGroup;
    @Value("${custom.import.saleInTara}")
    private String saleInTara;
    @Value("${custom.import.active}")
    private String active;
    @Value("${custom.import.fiscal}")
    private String fiscal;
    @Value("${custom.import.local}")
    private String local;
    @Value("${custom.import.printer}")
    private String printer;
    @Value("${custom.import.isExcise}")
    private String isExcise;
    @Value("${custom.import.idMeasure}")
    private String idMeasure;
    @Value("${custom.import.signFindBarcode}")
    private String signFindBarcode;


    @PostMapping("/array/articles-group")
    public void saveAllArticlesGroups(@RequestBody List<ArticlesGroup> articlesGroupList) {
        for (ArticlesGroup articlesGroup : articlesGroupList) {
            setDefaultArticlesGroup(articlesGroup);
        }
        importJsonService.saveAllArticlesGroups(articlesGroupList);
    }

    @PostMapping("/articles-group")
    public void saveAllArticlesGroups(@RequestBody ArticlesGroup articlesGroup) {
        setDefaultArticlesGroup(articlesGroup);
        importJsonService.saveArticleGroup(articlesGroup);
    }

    private void setDefaultArticlesGroup(ArticlesGroup articlesGroup) {
        if (articlesGroup.getIdShop() == null) {
            articlesGroup.setIdShop(Short.valueOf(idShop));
        }
        if (articlesGroup.getIdParentGroup() == null) {
            articlesGroup.setIdParentGroup(Integer.valueOf(idParentGroup));
        }
        if(articlesGroup.getSignActivity() == null) {
            articlesGroup.setSignActivity(Boolean.valueOf(signActivity));
        }
    }

    @PostMapping("/array/article")
    public void saveAllArticles(@RequestBody List<Article> articleList) {
        for (Article article : articleList) {
            setDefaultArticle(article);
        }
        importJsonService.saveAllArticles(articleList);
    }

    @PostMapping("/article")
    public void saveAllArticles(@RequestBody Article article) {
        setDefaultArticle(article);
        importJsonService.saveArticle(article);
    }

    private void setDefaultArticle(Article article) {
        if (article.getIdShop() == null) {
            article.setIdShop(Short.valueOf(idShop));
        }
        if (article.getIdMaker() == null) {
            article.setIdMaker(Integer.valueOf(idMaker));
        }
        if (article.getIdDepartment() == null) {
            article.setIdDepartment(Integer.valueOf(idDepartment));
        }
        if (article.getSname() == null) {
            article.setSname(article.getName().length() > 64 ? article.getName().substring(0, 64) : article.getName());
        }
        if (article.getDtype() == null) {
            article.setDtype(Short.valueOf(dtype));
        }
        if (article.getVatGroup() == null) {
            article.setVatGroup(vatGroup);
        }
        if (article.getSaleInTara() == null) {
            article.setSaleInTara(Boolean.valueOf(saleInTara));
        }
        if (article.getActive() == null) {
            article.setActive(Boolean.valueOf(active));
        }
        if (article.getFiscal() == null) {
            article.setFiscal(Boolean.valueOf(fiscal));
        }
        if (article.getLocal() == null) {
            article.setLocal(Boolean.valueOf(local));
        }
        if (article.getPrinter() == null) {
            article.setPrinter(Integer.valueOf(printer));
        }
        if (article.getIsExcise() == null) {
            article.setIsExcise(Integer.valueOf(isExcise));
        }
    }

    @PostMapping("/array/measure")
    public void saveAllMeasures(@RequestBody List<Measure> measureList) {
        importJsonService.saveAllMeasures(measureList);
    }

    @PostMapping("/measure")
    public void saveMeasure(@RequestBody Measure measure) {
        importJsonService.saveMeasure(measure);
    }

    @PostMapping("/array/barcode")
    public void saveAllBarcodes(@RequestBody List<Barcode> barcodeList) {
        for (Barcode barcode : barcodeList) {
            setDefaultBarcode(barcode);
        }
        importJsonService.saveAllBarcodes(barcodeList);
    }

    @PostMapping("/barcode")
    public void saveBarcode(@RequestBody Barcode barcode) {
        setDefaultBarcode(barcode);
        importJsonService.saveBarcode(barcode);
    }

    private void setDefaultBarcode(Barcode barcode) {
        if (barcode.getIdShop() == null) {
            barcode.setIdShop(Short.valueOf(idShop));
        }
        if (barcode.getIdMeasure() == null) {
            barcode.setIdMeasure(Integer.valueOf(idMeasure));
        }
        if (barcode.getSignFindBarcode() == null) {
            barcode.setSignFindBarcode(Short.valueOf(signFindBarcode));
        }
        if (barcode.getDtype() == null) {
            barcode.setDtype(Short.valueOf(dtype));
        }
    }

    @PostMapping("/array/profile")
    public void saveAllProfiles(@RequestBody List<Profile> profileList) {
        importJsonService.saveAllProfiles(profileList);
    }

    @PostMapping("/profile")
    public void saveProfile(@RequestBody Profile profile) {
        importJsonService.saveProfile(profile);
    }

    @PostMapping("/array/profile-events")
    public void saveAllProfileEvents(@RequestBody List<ProfileEvents> profileEventsList) {
        importJsonService.saveAllProfileEvents(profileEventsList);
    }

    @PostMapping("/profile-events")
    public void saveAllProfileEvents(@RequestBody ProfileEvents profileEvents) {
        importJsonService.saveProfileEvents(profileEvents);
    }

    @PostMapping("/array/user")
    public void saveAllUsers(@RequestBody List<User> userList) {
        importJsonService.saveAllUsers(userList);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        importJsonService.saveUser(user);
    }

    @PostMapping("/array/ban-article")
    public void saveAllBanArticles(@RequestBody List<BanArticle> banArticleList) {
        importJsonService.saveAllBanArticles(banArticleList);
    }

    @PostMapping("/ban-article")
    public void saveBanArticle(@RequestBody BanArticle banArticle) {
        importJsonService.saveBanArticle(banArticle);
    }

    @PostMapping("/array/client")
    public void saveAllClients(@RequestBody List<Client> clientList) {
        importJsonService.saveAllClients(clientList);
    }

    @PostMapping("/client")
    public void saveUser(@RequestBody Client client) {
        importJsonService.saveClient(client);
    }

    @PostMapping("/array/currency")
    public void saveAllCurrencies(@RequestBody List<Currency> currencyList) {
        importJsonService.saveAllCurrencies(currencyList);
    }

    @PostMapping("/currency")
    public void saveCurrency(@RequestBody Currency currency) {
        importJsonService.saveCurrency(currency);
    }

    @PostMapping("/array/discount")
    public void saveAllDiscounts(@RequestBody List<Discount> discountList) {
        importJsonService.saveAllDiscounts(discountList);
    }

    @PostMapping("/discount")
    public void saveDiscount(@RequestBody Discount discount) {
        importJsonService.saveDiscount(discount);
    }

    @PostMapping("/array/discount-item")
    public void saveAllDiscountItems(@RequestBody List<DiscountItem> discountItemList) {
        importJsonService.saveAllDiscountItems(discountItemList);
    }

    @PostMapping("/discount-item")
    public void saveDiscountItem(@RequestBody DiscountItem discountItem) {
        importJsonService.saveDiscountItem(discountItem);
    }

    @PostMapping("/array/event")
    public void saveAllEvents(@RequestBody List<Event> eventList) {
        importJsonService.saveAllEvents(eventList);
    }

    @PostMapping("/event")
    public void saveEvent(@RequestBody Event event) {
        importJsonService.saveEvent(event);
    }

    @PostMapping("/array/invoice")
    public void saveAllInvoices(@RequestBody List<Invoice> invoiceList) {
        importJsonService.saveAllInvoices(invoiceList);
    }

    @PostMapping("/invoice")
    public void saveInvoice(@RequestBody Invoice invoice) {
        importJsonService.saveInvoice(invoice);
    }

    @PostMapping("/array/invoice-articles")
    public void saveAllInvoiceArticles(@RequestBody List<InvoiceArticles> invoiceArticlesList) {
        importJsonService.saveAllInvoiceArticles(invoiceArticlesList);
    }

    @PostMapping("/invoice-articles")
    public void saveInvoiceArticles(@RequestBody InvoiceArticles invoiceArticles) {
        importJsonService.saveInvoiceArticles(invoiceArticles);
    }

    @PostMapping("/array/variable")
    public void saveAllVariables(@RequestBody List<Variable> variableList) {
        importJsonService.saveAllVariables(variableList);
    }

    @PostMapping("/variable")
    public void saveVariable(@RequestBody Variable variable) {
        importJsonService.saveVariable(variable);
    }
}
