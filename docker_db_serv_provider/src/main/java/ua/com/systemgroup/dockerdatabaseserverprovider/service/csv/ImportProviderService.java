package ua.com.systemgroup.dockerdatabaseserverprovider.service.csv;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;
import ua.com.systemgroup.dockerdatabaseserverprovider.filter.GenericFilter;
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
import ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey.ClientPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.UserPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ProfilePk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ProfileEventsPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.MeasurePk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.BarcodePk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ArticlePk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.BanArticlePk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ArticlesGroupPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.DiscountPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.DiscountItemPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.CurrencyPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.EventPk;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.VariablePk;
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
import ua.com.systemgroup.dockerdatabaseserverprovider.util.ImportCsvUtil;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@DisallowConcurrentExecution
@Slf4j
public class ImportProviderService implements Job {

    private final ImportCsvUtil<ArticlesGroup, ArticlesGroupPk> importCsvUtilArticlesGroup;
    private final ArticlesGroupRepository articlesGroupRepository;
    private final GenericFilter genericFilter;
    private final ImportCsvUtil<Article, ArticlePk> importCsvUtilArticle;
    private final ArticleRepository articleRepository;
    private final ImportCsvUtil<Measure, MeasurePk> importCsvUtilMeasure;
    private final MeasureRepository measureRepository;
    private final ImportCsvUtil<Barcode, BarcodePk> importCsvUtilBarcode;
    private final BarcodeRepository barcodeRepository;
    private final ImportCsvUtil<Profile, ProfilePk> importCsvUtilProfile;
    private final ProfileRepository profileRepository;
    private final ImportCsvUtil<User, UserPk> importCsvUtilUser;
    private final UserRepository userRepository;
    private final ImportCsvUtil<ProfileEvents, ProfileEventsPk> importCsvUtilProfileEvents;
    private final ProfileEventsRepository profileEventsRepository;
    private final ImportCsvUtil<BanArticle, BanArticlePk> importCsvUtilBanArticle;
    private final BanArticleRepository banArticleRepository;
    private final ImportCsvUtil<Client, ClientPk> importCsvUtilClient;
    private final ClientRepository clientRepository;
    private final ImportCsvUtil<Currency, CurrencyPk> importCsvUtilCurrency;
    private final CurrencyRepository currencyRepository;
    private final ImportCsvUtil<Discount, DiscountPk> importCsvUtilDiscount;
    private final DiscountRepository discountRepository;
    private final ImportCsvUtil<DiscountItem, DiscountItemPk> importCsvUtilDiscountItem;
    private final DiscountItemRepository discountItemRepository;
    private final ImportCsvUtil<Event, EventPk> importCsvUtilEvent;
    private final EventRepository eventRepository;
    private final ImportCsvUtil<InvoiceArticles, Short> importCsvUtilInvoiceArticles;
    private final InvoiceArticlesRepository invoiceArticlesRepository;
    private final ImportCsvUtil<Invoice, UUID> importCsvUtilInvoice;
    private final InvoiceRepository invoiceRepository;
    private final ImportCsvUtil<Variable, VariablePk> importCsvUtilVariable;
    private final VariableRepository variableRepository;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("Executing Quartz Job ImportProviderService at " + System.currentTimeMillis());

        try {
            genericFilter.setFilename("t_articles_group");
            String[] fileNames = importCsvUtilArticlesGroup.getFileNames(genericFilter);
            Arrays.asList(fileNames).forEach(fileName -> {
                List<ArticlesGroup> articlesGroups = importCsvUtilArticlesGroup.findListEntityFromCSVByType(ArticlesGroup.class, fileName);
                importCsvUtilArticlesGroup.saveAll(articlesGroupRepository, articlesGroups);
                importCsvUtilArticlesGroup.renameFile(fileName);
            });

            genericFilter.setFilename("t_article");
            fileNames = importCsvUtilArticle.getFileNames(genericFilter);
            Arrays.asList(fileNames).forEach(fileName -> {
                List<Article> articles = importCsvUtilArticle.findListEntityFromCSVByType(Article.class, fileName);
                importCsvUtilArticle.saveAll(articleRepository, articles);
                importCsvUtilArticle.renameFile(fileName);
            });

            genericFilter.setFilename("t_measure");
            String[] fileNames10 = importCsvUtilMeasure.getFileNames(genericFilter);
            Arrays.asList(fileNames10).forEach(fileName -> {
                List<Measure> measures = importCsvUtilMeasure.findListEntityFromCSVByType(Measure.class, fileName);
                importCsvUtilMeasure.saveAll(measureRepository, measures);
                importCsvUtilMeasure.renameFile(fileName);
            });

            genericFilter.setFilename("t_barcode");
            String[] fileNames11 = importCsvUtilBarcode.getFileNames(genericFilter);
            Arrays.asList(fileNames11).forEach(fileName -> {
                List<Barcode> barcodes = importCsvUtilBarcode.findListEntityFromCSVByType(Barcode.class, fileName);
                importCsvUtilBarcode.saveAll(barcodeRepository, barcodes);
                importCsvUtilBarcode.renameFile(fileName);
            });

        } catch (Exception e) {
            log.error("t_articles_group, t_article, t_measure, t_barcode error", e);
        }

        try {
            genericFilter.setFilename("t_ban_article");
            String[] fileNames1 = importCsvUtilBanArticle.getFileNames(genericFilter);
            Arrays.asList(fileNames1).forEach(fileName -> {
                List<BanArticle> banArticles = importCsvUtilBanArticle.findListEntityFromCSVByType(BanArticle.class, fileName);
                importCsvUtilBanArticle.saveAll(banArticleRepository, banArticles);
                importCsvUtilBanArticle.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_ban_article error", e);
        }

        try {
            genericFilter.setFilename("t_client");
            String[] fileNames2 = importCsvUtilClient.getFileNames(genericFilter);
            Arrays.asList(fileNames2).forEach(fileName -> {
                List<Client> clients = importCsvUtilClient.findListEntityFromCSVByType(Client.class, fileName);
                importCsvUtilClient.saveAll(clientRepository, clients);
                importCsvUtilClient.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_client error", e);
        }

        try {
            genericFilter.setFilename("t_currency");
            String[] fileNames3 = importCsvUtilCurrency.getFileNames(genericFilter);
            Arrays.asList(fileNames3).forEach(fileName -> {
                List<Currency> currencies = importCsvUtilCurrency.findListEntityFromCSVByType(Currency.class, fileName);
                importCsvUtilCurrency.saveAll(currencyRepository, currencies);
                importCsvUtilCurrency.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_currency error", e);
        }

        try {
            genericFilter.setFilename("t_discount");
            String[] fileNames4 = importCsvUtilDiscount.getFileNames(genericFilter);
            Arrays.asList(fileNames4).forEach(fileName -> {
                List<Discount> discounts = importCsvUtilDiscount.findListEntityFromCSVByType(Discount.class, fileName);
                importCsvUtilDiscount.saveAll(discountRepository, discounts);
                importCsvUtilDiscount.renameFile(fileName);
            });

            genericFilter.setFilename("t_discount_item");
            String[] fileNames5 = importCsvUtilDiscountItem.getFileNames(genericFilter);
            Arrays.asList(fileNames5).forEach(fileName -> {
                List<DiscountItem> discountItems = importCsvUtilDiscountItem.findListEntityFromCSVByType(DiscountItem.class, fileName);
                importCsvUtilDiscountItem.saveAll(discountItemRepository, discountItems);
                importCsvUtilDiscountItem.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_discount, t_discount_item error", e);
        }

        try {
            genericFilter.setFilename("t_event");
            String[] fileNames6 = importCsvUtilEvent.getFileNames(genericFilter);
            Arrays.asList(fileNames6).forEach(fileName -> {
                List<Event> discountItems = importCsvUtilEvent.findListEntityFromCSVByType(Event.class, fileName);
                importCsvUtilEvent.saveAll(eventRepository, discountItems);
                importCsvUtilEvent.renameFile(fileName);
            });

            genericFilter.setFilename("t_profile");
            String[] fileNames12 = importCsvUtilProfile.getFileNames(genericFilter);
            Arrays.asList(fileNames12).forEach(fileName -> {
                List<Profile> profiles = importCsvUtilProfile.findListEntityFromCSVByType(Profile.class, fileName);
                importCsvUtilProfile.saveAll(profileRepository, profiles);
                importCsvUtilProfile.renameFile(fileName);
            });

            genericFilter.setFilename("t_profile_events");
            String[] fileNames14 = importCsvUtilProfileEvents.getFileNames(genericFilter);
            Arrays.asList(fileNames14).forEach(fileName -> {
                List<ProfileEvents> profileEvents = importCsvUtilProfileEvents.findListEntityFromCSVByType(ProfileEvents.class, fileName);
                importCsvUtilProfileEvents.saveAll(profileEventsRepository, profileEvents);
                importCsvUtilProfileEvents.renameFile(fileName);
            });

            genericFilter.setFilename("t_user");
            String[] fileNames13 = importCsvUtilUser.getFileNames(genericFilter);
            Arrays.asList(fileNames13).forEach(fileName -> {
                List<User> users = importCsvUtilUser.findListEntityFromCSVByType(User.class, fileName);
                importCsvUtilUser.saveAll(userRepository, users);
                importCsvUtilUser.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_event, t_profile, t_profile_events, t_user", e);
        }

        try {
            genericFilter.setFilename("t_invoice_articles");
            String[] fileNames7 = importCsvUtilInvoiceArticles.getFileNames(genericFilter);
            Arrays.asList(fileNames7).forEach(fileName -> {
                List<InvoiceArticles> invoiceArticles = importCsvUtilInvoiceArticles.findListEntityFromCSVByType(InvoiceArticles.class, fileName);
                importCsvUtilInvoiceArticles.saveAll(invoiceArticlesRepository, invoiceArticles);
                importCsvUtilInvoiceArticles.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_invoice_articles", e);
        }

        try {
            genericFilter.setFilename("t_invoice");
            String[] fileNames8 = importCsvUtilInvoice.getFileNames(genericFilter);
            Arrays.asList(fileNames8).forEach(fileName -> {
                List<Invoice> invoices = importCsvUtilInvoice.findListEntityFromCSVByType(Invoice.class, fileName);
                importCsvUtilInvoice.saveAll(invoiceRepository, invoices);
                importCsvUtilInvoice.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_invoice", e);
        }

        try {
            genericFilter.setFilename("t_variable");
            String[] fileNames9 = importCsvUtilVariable.getFileNames(genericFilter);
            Arrays.asList(fileNames9).forEach(fileName -> {
                List<Variable> variables = importCsvUtilVariable.findListEntityFromCSVByType(Variable.class, fileName);
                importCsvUtilVariable.saveAll(variableRepository, variables);
                importCsvUtilVariable.renameFile(fileName);
            });
        } catch (Exception e) {
            log.error("t_variable", e);
        }
    }
}
