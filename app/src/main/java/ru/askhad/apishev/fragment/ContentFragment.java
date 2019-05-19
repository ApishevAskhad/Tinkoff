package ru.askhad.apishev.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import ru.askhad.apishev.R;

public class ContentFragment extends Fragment {
    private WebView mWebView;

    //при вставке строки через Ctrl + V IDEA добавляет backslash для экронирования \
    private String sample = "<p>Москва, Россия&nbsp;&mdash; 19 декабря 2017&nbsp;г.<br />\nСегодня клиенты Тинькофф Банка получили доступ к&nbsp;системе бесконтактной оплаты Garmin Pay.</p>\n\n<p>Garmin Pay&nbsp;&mdash; удобный и&nbsp;безопасный способ оплаты для владельцев часов Garmin. Сервис разработан для людей, которые ведут активный образ жизни, и&nbsp;спортсменов&nbsp;&mdash; им&nbsp;будет особенно удобно расплатиться часами, даже если под рукой нет карты или смартфона.</p>\\n\\n<p>Перед покупкой необходимо с&nbsp;помощью смартфона создать виртуальный кошелек в&nbsp;приложении Garmin Connect и&nbsp;привязать к&nbsp;нему кредитную или дебетовую карту Mastercard Тинькофф Банка.</p>\\n\\n<p>Для оплаты достаточно ввести пароль из&nbsp;<nobr>4-х</nobr> цифр и&nbsp;приложить часы к&nbsp;терминалу.</p>\\n\\n<p>Пароль будет запрашиваться в&nbsp;следующих случаях:</p>\\n\\n<ul class=\\\"bull\\\">\\n\\t<li>Первое использование после снятия часов;</li>\\n\\t<li>Прошло более <nobr>24-х</nobr> часов с&nbsp;момента последней оплаты;</li>\\n\\t<li>На&nbsp;часах отключен датчик пульса.</li>\\n</ul>\\n\\n<p>На&nbsp;текущий момент с&nbsp;сервисом Garmin Pay совместима модель часов vivoactive 3.</p>\\n\\n<p>Garmin не&nbsp;будет удерживать комиссию за&nbsp;использование технологии Garmin Pay с&nbsp;пользователей, <nobr>банков-эмитентов</nobr>, <nobr>банков-эквайеров</nobr> и&nbsp;торговых предприятий.</p>";

    public static ContentFragment newInstance() {
        return new ContentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mWebView = view.findViewById(R.id.web_view);
        mWebView.loadData(sample, "text/html; charset=utf-8", "utf-8");
    }
}
