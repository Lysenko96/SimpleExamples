package ua.com.systemgroup.dockerdatabaseserverprovider.service.json;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.Client;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.User;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Profile;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.ProfileEvents;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Measure;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Barcode;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Article;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.BanArticle;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.ArticlesGroup;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Discount;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.DiscountItem;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Currency;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Invoice;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.InvoiceArticles;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Event;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Variable;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.ClientRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.UserRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.ProfileRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.ProfileEventsRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.MeasureRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.BarcodeRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.ArticleRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.BanArticleRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.ArticlesGroupRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.DiscountRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.DiscountItemRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.CurrencyRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.InvoiceRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.InvoiceArticlesRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.EventRepository;
import ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports.VariableRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ImportJsonService {

    private final ArticlesGroupRepository articlesGroupRepository;
    private final ArticleRepository articleRepository;
    private final MeasureRepository measureRepository;
    private final BarcodeRepository barcodeRepository;
    private final ProfileRepository profileRepository;
    private final ProfileEventsRepository profileEventsRepository;
    private final UserRepository userRepository;
    private final BanArticleRepository banArticleRepository;
    private final ClientRepository clientRepository;
    private final CurrencyRepository currencyRepository;
    private final DiscountRepository discountRepository;
    private final DiscountItemRepository discountItemRepository;
    private final EventRepository eventRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceArticlesRepository invoiceArticlesRepository;
    private final VariableRepository variableRepository;

    public void saveArticleGroup(ArticlesGroup articlesGroup) {
        articlesGroupRepository.save(articlesGroup);
    }

    public void saveAllArticlesGroups(List<ArticlesGroup> articlesGroupList) {
        articlesGroupRepository.saveAll(articlesGroupList);
    }

    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    public void saveAllArticles(List<Article> articleList) {
        articleRepository.saveAll(articleList);
    }

    public void saveMeasure(Measure measure) {
        measureRepository.save(measure);
    }

    public void saveAllMeasures(List<Measure> measureList) {
        measureRepository.saveAll(measureList);
    }

    public void saveBarcode(Barcode barcode) {
        barcodeRepository.save(barcode);
    }

    public void saveAllBarcodes(List<Barcode> barcodeList) {
        barcodeRepository.saveAll(barcodeList);
    }

    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public void saveAllProfiles(List<Profile> profileList) {
        profileRepository.saveAll(profileList);
    }

    public void saveProfileEvents(ProfileEvents profileEvents) {
        profileEventsRepository.save(profileEvents);
    }

    public void saveAllProfileEvents(List<ProfileEvents> profileEventsList) {
        profileEventsRepository.saveAll(profileEventsList);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveAllUsers(List<User> userList) {
        userRepository.saveAll(userList);
    }

    public void saveBanArticle(BanArticle banArticle) {
        banArticleRepository.save(banArticle);
    }

    public void saveAllBanArticles(List<BanArticle> banArticleList) {
        banArticleRepository.saveAll(banArticleList);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void saveAllClients(List<Client> clientList) {
        clientRepository.saveAll(clientList);
    }

    public void saveCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    public void saveAllCurrencies(List<Currency> currencyList) {
        currencyRepository.saveAll(currencyList);
    }

    public void saveDiscountItem(DiscountItem discountItem) {
        discountItemRepository.save(discountItem);
    }

    public void saveAllDiscountItems(List<DiscountItem> discountItemList) {
        discountItemRepository.saveAll(discountItemList);
    }

    public void saveDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public void saveAllDiscounts(List<Discount> discounts) {
        discountRepository.saveAll(discounts);
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public void saveAllEvents(List<Event> eventList) {
        eventRepository.saveAll(eventList);
    }

    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void saveAllInvoices(List<Invoice> invoiceList) {
        invoiceRepository.saveAll(invoiceList);
    }

    public void saveInvoiceArticles(InvoiceArticles invoiceArticles) {
        invoiceArticlesRepository.save(invoiceArticles);
    }

    public void saveAllInvoiceArticles(List<InvoiceArticles> invoiceArticlesList) {
        invoiceArticlesRepository.saveAll(invoiceArticlesList);
    }

    public void saveVariable(Variable variable) {
        variableRepository.save(variable);
    }

    public void saveAllVariables(List<Variable> variableList) {
        variableRepository.saveAll(variableList);
    }

}
