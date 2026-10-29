# Automation ID (локаторы Appium)

Стабильные идентификаторы для UI-автоматизации. В коде каждый задаётся через
`SemanticsId` (`packages/shared/lib/common/presentation/widgets/semantics_id.dart`),
который ставит `Semantics.identifier` на собственный semantics-узел элемента.

| Flutter | Android (Appium) | iOS (Appium) |
| --- | --- | --- |
| `Semantics.identifier` | `resource-id` → `By.id("…")` | `accessibilityIdentifier` → `AppiumBy.accessibilityId("…")` |

Правила:

- ID берутся из колонки «Proposed logical ID» задачи на автоматизацию.
  **Жирным** выделены кнопки, которых не было в задаче; их ID построены по той же
  схеме именования.
- ID никогда не содержат локализованный текст, имена, цены или позиции в списке. Повторяющиеся
  элементы (карточки уроков, учителя, слоты, ученики) получают `<role>.<technical key>`,
  например `schedule.lesson_card.<classId>`; элементы управления внутри такого элемента сохраняют
  ID своей роли и ищутся внутри элемента.
- Такие ID собираются через `keyedSemanticsId(role, key)`: если ключа ещё нет (`null`),
  элемент получает просто ID роли, без хвоста `.null`.
- Озвучиваемая метка (`content-desc` / iOS `label`) не меняется; текст и
  состояния (enabled, selected, checked) читаются отдельно от идентификатора.
- Содержимое WebView (квиз регистрации, веб-флоу покупки, портал Stripe, страницы
  оплаты, kids area, чат поддержки) не размечается.

## Экраны

- **Авторизация, регистрация, онбординг:** Приветственный экран (Try for Free / Sign in); Слайды онбординга; Способы входа; Вход по email/телефону (legacy; в China-приложении открывается сразу); Восстановление пароля; Восстановление пароля: успех; Восстановление пароля: новый пароль; Регистрация: данные аккаунта (нативная); Регистрация (WebView, по remote config); Регистрация: OTP по email; Регистрация: добавление телефона; Регистрация: данные ученика (запись на пробный); Регистрация: слот уже занят (повторный выбор); Регистрация: успех; Главная: блок «пробный урок записан»; Родительский контроль (parental gate, overlay); Согласие Google Analytics (шторка); Пользователь из Китая (шторка); Общие виджеты раздела
- **Навигация, меню профиля, главная, расписание:** Нижняя навигация; Главная (Dashboard); Расписание (Schedule); Входящие (App Inbox); Общие виджеты раздела
- **Уроки и бронирование:** Выбор учителя (бронирование); Фильтры бронирования; Карточка / детали урока; Шторка действий с уроком (Schedule bottom sheet); Перенос урока, новый флоу; Перенос урока, legacy-диалог; Урок перенесён; Выбор слота, legacy; Выбор учителя, legacy; Урок забронирован; Реферальный экран после брони; Запрос слота (Ask for slot); Синхронизация календаря; Групповое расписание; Класс (урок); Прочее
- **Подписка и оплата:** Управление подпиской (Stripe); Изменение подписки (WebView, нативная оболочка); Платёжные данные (портал Stripe, нативная оболочка); Отмена подписки (Stripe); Пауза подписки (Stripe); Пауза подписки (legacy); Пауза групповой подписки; Флоу паузы подписки (новый); Пауза / удержание в сезонном челлендже (лето / зима); Предложение удержания при отмене подписки; Подтверждение отписки; Отложенная подписка; Причина отмены (legacy); Информация о балансе / Моя подписка; Смена / покупка подписки (нативная); Изменение периода подписки; Изменение числа уроков в неделю; Изменение категории учителя; Покупка подписки (выбор плана, общий виджет `BuySubscription`); Выбор способа оплаты; Оплата через Stripe checkout (нативная оболочка); Виджеты подписки на главной (dashboard)
- **Профиль, аккаунт, рефералка, учителя:** Аккаунт (меню аккаунта); Личные данные; Профиль родителя (старый экран профиля); История баланса; Редактирование данных детей; Добавление ребёнка; Управление паролем (старый экран); Установка пароля (табы: новый пароль → способ → код); Пароль изменён; Реферальная программа; Реферальный экран успеха (после оплаты); Реферальный экран успеха после пробного; Успех (универсальный экран успеха); Профиль учителя; Детали учителя (старый экран учителя); Избранные учителя; Расписание учителя; Подтверждение учителя; Поиск учителя по имени; Выбор учителя (устаревший список, `FullTeachersList`); Диалог профилей учеников (выбор ученика); Регистрация (общие виджеты, используются в `features/sign_up/.../student_data_page.dart`); Ученик (legacy-экран ученика, роута нет); Лента активности: реферальное напоминание; Поделиться (сертификат / Nutty tale через `FacebookShare`)
- **Библиотека, достижения, челленджи, контент:** Библиотека; Достижения (вкладки учеников); Программа (карта программы); Результаты оценки; Сертификат; Nutty tale; Завершение уровня; Сертификат о завершении уровня; Завершение юнита; Сезонный челлендж (WebView); Баннеры челленджей на главной (summer / winter / monthly); Упражнения на главной (виджет на главной); Видео-хайлайт; Общий видеоплеер; Каталог курсов (нативная оболочка WebView); Кабинет ученика (Kids area, WebView); Оценка урока (`EvaluateLesson` / `EvaluateWidget`, экран завершённого урока); Плашка действий под активностью (`EvaluateActivityTileWidget`)
- **Общие виджеты и диалоги:** 1. API для мест вызова (параметры без id по умолчанию); 2. BaseDialog: автоматические id для всех наследников; Наследники BaseDialog в общих виджетах; 3. Устаревшие диалоги; DeprecatedBaseDialog; DeprecatedRoundCornersDialog; 4. Шторки (bottom sheets) и оверлеи; 5. Виджеты ошибок и повтора; 6. Нативная оболочка WebView; 7. OTP: подтверждение кода (`PinConfirm`); 8. Элемент расписания (`ItemSchedule`) и кнопка Join на главной

### Централизованные ID

- Все стандартные кнопки «назад» и «закрыть» в `AppBar` получают `navigation.back_button` и
  `navigation.close_button` через `actionIconTheme` в `common/data/core/theme/app_theme.dart`.
- Кнопки всех диалогов на `BaseDialog` получают `<prefix>.confirm_button`, `<prefix>.cancel_button`,
  `<prefix>.close_button` (префикс по умолчанию `dialog`, задаётся `DialogParams.semanticsIdPrefix`).
- Кнопки повтора в `RefreshErrorWidget` / `WebViewErrorWidget`: `common.retry_button`, если экран
  не передал свой `semanticsId`.

### Чекбоксы, радиокнопки, переключатели, вкладки

Сводка по элементам выбора из таблиц ниже. Состояние (checked / selected / toggled) читается из атрибутов того же элемента.

#### Чекбоксы

| Элемент | Идентификатор |
| --- | --- |
| **Чекбокс дня** | `booking_filters.lesson_time.day_checkbox.<yyyy-MM-dd>` |
| **Отмена урока: чекбокс «все еженедельные»** | `lesson_cancellation.weekly_checkbox` |

#### Радиокнопки и варианты выбора

| Элемент | Идентификатор |
| --- | --- |
| **Радио-вариант в диалоге выбора** | `booking.choice_dialog.variant_option.$value` |
| **Пункт времени** | `reschedule.time_option.$time` |
| Выбор ученика (dropdown) + пункты | `booking.student_option.${value.id}` |
| Тип учителя (dropdown) + пункты | `booking.teacher_level_option.${value.name}` |
| **Аудиовыход (всплывающее меню) + пункты** | `classroom.audio_output_option.${e.deviceId}` |
| **Тип учителя Standard / Premium (регистрация)** | `teacher_type_selector.standard_option` |
| **Тип учителя Standard / Premium (регистрация)** | `teacher_type_selector.premium_option` |
| **Карточка рекомендованного периода (7/14/… дней)** | `subscription_pause.duration_option.$days` |
| «Monthly payment» | `purchase.monthly_payment_option` |
| «Pay in full» | `purchase.full_payment_option` |
| **«Use bonuses» (радиокнопка)** | `purchase_summary.use_bonuses_option` |
| **«Promo code» (радиокнопка, контейнер вокруг PromoCodeWidget)** | `purchase_summary.promo_code_option` |
| Вариант длительности (`3_months`, `6_months`, `12_months`, или `N_weeks`) | `purchase.duration_${durationKey}_option` |
| **«Start immediately» (радиокнопка)** | `purchase.start_immediately_option` |
| **«Start from date» (радиокнопка, контейнер)** | `purchase.start_date_option` |
| Замещающий учитель — «да» (чекбокс) | `profile.substitute_teacher_yes_option` |
| Замещающий учитель — «нет» (чекбокс) | `profile.substitute_teacher_no_option` |
| **Пол: девочка (радиокнопка)** | `add_child.gender_female_option` |
| **Пол: мальчик (радиокнопка)** | `add_child.gender_male_option` |
| **Отправить код на телефон (чекбокс)** | `set_password.phone_option` |
| **Отправить код на e-mail (чекбокс)** | `set_password.email_option` |
| **Пол: девочка** | `registration.gender_female_option` |
| **Пол: мальчик** | `registration.gender_male_option` |
| **Пункт меню «Скачать»** | `highlight_video.download_option` |
| **Пункт меню «Поделиться»** | `highlight_video.share_option` |

#### Переключатели

| Элемент | Идентификатор |
| --- | --- |
| **Переключатель «analytics storage»** | `ga_consent.analytics_storage_switch` |
| **Переключатель «ad storage»** | `ga_consent.ad_storage_switch` |
| **Переключатель «ad user data»** | `ga_consent.ad_user_data_switch` |
| **Переключатель «ad personalization»** | `ga_consent.ad_personalization_switch` |
| «Repeat weekly» (переключатель) | `weekly_booking.enabled_switch` |
| **«Book by time» (переключатель)** | `booking.book_by_time_switch` |

#### Вкладки

| Элемент | Идентификатор |
| --- | --- |
| Вкладка «Email» | `login.email_tab` |
| Вкладка «Phone» | `login.phone_tab` |
| **Таб ученика (если пробных уроков несколько; ключ — student.id)** | `trial_onboarding.student_tab.<studentId>` |
| Таб Dashboard (Home) | `navigation.home_tab` |
| Таб Schedule (календарь) | `navigation.schedule_tab` |
| **Таб Kids area** | `navigation.kids_area_tab` |
| **Таб Achievements** | `navigation.achievements_tab` |
| **Таб Monthly challenge** | `navigation.monthly_challenge_tab` |
| **Таб Summer challenge** | `navigation.summer_challenge_tab` |
| **Таб Winter challenge** | `navigation.winter_challenge_tab` |
| **Таб Bonuses** | `navigation.bonuses_tab` |
| **Таб Referral** | `navigation.referral_tab` |
| **Таб Support (чат)** | `navigation.support_tab` |
| **Таб «Before lesson» в карточке** | `home.next_lesson_before_lesson_tab` |
| **Таб «Materials» в карточке** | `home.next_lesson_materials_tab` |
| **Таб Upcoming / Past** | `schedule.upcoming_tab` |
| **Таб Upcoming / Past** | `schedule.past_tab` |
| **Вкладки Weekly / One-time** | `booking_filters.lesson_time.weekly_tab` |
| **Вкладки Weekly / One-time** | `booking_filters.lesson_time.one_time_tab` |
| **«Weekly» / «One-time» (NovakidTabBar `semanticsId` + `tabSemanticsIds`)** | `ask_slot.weekly_tab` |
| **«Weekly» / «One-time» (NovakidTabBar `semanticsId` + `tabSemanticsIds`)** | `ask_slot.one_time_tab` |
| **Вкладка уровня преподавателя (standard / premium)** | `purchase.teacher_level_tab.${e.name}` |
| **Вкладка уровня (enum `TeacherLevel`)** | `subscription_teacher_category.level_tab.${e.name}` |
| **Таб «Ссылка»** | `referral.link_tab` |
| **Таб «Бонусы»** | `referral.bonuses_tab` |
| **Таб Weekly (нет в trial)** | `teacher_schedule.weekly_tab` |
| **Таб One-time** | `teacher_schedule.one_time_tab` |
| **Вкладка ученика (TabBar)** | `achievements.student_tab.${student.id}` |
| **Вкладка ученика, когда TabBar приходит из экрана завершения юнита** | `program.student_tab.${student.id}` |
| **Вкладка «Освоено»** | `assessment.confirmed_tab` |
| **Вкладка «Подтянуть»** | `assessment.to_improve_tab` |

## Авторизация, регистрация, онбординг

Пути относительно `packages/shared/lib`. Строки — строка с `id:` / `identifier:` в текущем (незакоммиченном) файле.

### Приветственный экран (Try for Free / Sign in) — `features/onboarding_slides_page/welcome_novakid_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Try for Free» (телефон) | `features/onboarding_slides_page/presentation/widgets/welcome_buttons.dart:45` | `welcome.try_for_free_button` | 1 |
| 2 | «Sign in» (телефон) | `features/onboarding_slides_page/presentation/widgets/welcome_buttons.dart:17` | `welcome.sign_in_button` | 2 |
| 3 | «Try for Free» (планшет) | `features/onboarding_slides_page/presentation/widgets/welcome_content_tablet.dart:60` | `welcome.try_for_free_button` | 1 |
| 4 | «Sign in» (планшет) | `features/onboarding_slides_page/presentation/widgets/welcome_content_tablet.dart:82` | `welcome.sign_in_button` | 2 |

### Слайды онбординга — `features/onboarding_slides_page/onboarding_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Back» (назад по слайдам)** | `features/onboarding_slides_page/onboarding_slides_page_content.dart:82` | **`onboarding.back_button`** | — |
| 2 | **«Skip»** | `features/onboarding_slides_page/onboarding_slides_page_content.dart:94` | **`onboarding.skip_button`** | — |
| 3 | **«Next» (круглая кнопка со стрелкой)** | `features/onboarding_slides_page/onboarding_slides_page_content.dart:219` | **`onboarding.next_button`** | — |
| 4 | **«Try for Free» (последний слайд)** | `features/onboarding_slides_page/onboarding_slides_page_content.dart:190` | **`onboarding.try_for_free_button`** | — |
| 5 | **«Log in» (последний слайд)** | `features/onboarding_slides_page/onboarding_slides_page_content.dart:202` | **`onboarding.sign_in_button`** | — |

### Способы входа — `features/sign_in/social_media/presentation/sign_in_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Sign in with Google» | `features/sign_in/social_media/presentation/widgets/prepared.dart:29` | `login.google_button` | 4 |
| 2 | «Sign in with Apple» | `features/sign_in/social_media/presentation/widgets/prepared.dart:34` | `login.apple_button` | 3 |
| 3 | «Sign in with email/phone» | `features/sign_in/social_media/presentation/widgets/prepared.dart:43` | `login.email_phone_button` | 5 |
| 4 | «Register» (ссылка в тексте, `TextSpan.semanticsIdentifier`) | `features/sign_in/social_media/presentation/widgets/prepared.dart:67` | `login.sign_up_link` | 6 |

#### Диалог ошибки входа — `features/sign_in/social_media/presentation/dialogs/fail_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Close» | `features/sign_in/social_media/presentation/dialogs/fail_dialog.dart:15` (`semanticsIdPrefix`) | `login.dialog.close_button` | 296 |

### Вход по email/телефону (legacy; в China-приложении открывается сразу) — `features/sign_in/legacy/presentation/sign_in_legacy_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Вкладка «Email» | `features/sign_in/legacy/presentation/widgets/sign_in_field.dart:112` | `login.email_tab` | 7 |
| 2 | Вкладка «Phone» | `features/sign_in/legacy/presentation/widgets/sign_in_field.dart:125` | `login.phone_tab` | 8 |
| 3 | Поле телефона: контейнер (поле + выбор кода страны) | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:43` | `login.phone_input` | 16 |
| 4 | **Подсказка домена email («Did you mean …»)** | `features/sign_in/legacy/presentation/widgets/email_domain_suggestion_view.dart:28` | **`login.email_suggestion_link`** | — |
| 5 | «Continue» (режим кода доступа, «Choose») | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:213` | `login.continue_button` | 11 |
| 6 | «Sign in with password» (переключение в режим пароля) | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:227` | `login.password_mode_button` | 12 |
| 7 | «Sign in with access code» (переключение в режим кода) | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:187` | `login.access_code_mode_button` | 13 |
| 8 | «Sign in» (отправка, режим пароля) | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:160` | `login.submit_button` | 14 |
| 9 | «Forgot password» | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:196` | `login.forgot_password_link` | 15 |
| 10 | Показать/скрыть пароль (параметр `visibilityButtonSemanticsId` в `TitleBorderTextField`) | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:149` | `login.password_visibility_button` | 18 |
| 11 | **WeChat (только China, флаг GrowthBook)** | `features/sign_in/legacy/presentation/widgets/forms/sign_in_form.dart:248` | **`login.wechat_button`** | — |

#### OTP (форма кода на той же странице)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Resend code» (активна) | `features/sign_in/legacy/presentation/widgets/confirm/pin_confirm.dart:95` | `otp.resend_button` | 22 |
| 2 | Обратный отсчёт «Resend» (та же кнопка, неактивна, с таймером) | `features/sign_in/legacy/presentation/widgets/confirm/pin_confirm.dart:76` | `otp.resend_timer` | 23 |
| 3 | «Change email / phone» | `features/sign_in/legacy/presentation/widgets/forms/confirm_code_form.dart:50` | `otp.change_contact_button` | 24 |

#### Диалог ошибки входа — `features/sign_in/legacy/presentation/dialogs/fail_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Close» | `features/sign_in/legacy/presentation/dialogs/fail_dialog.dart:15` (`semanticsIdPrefix`) | `login.dialog.close_button` | 296 |

### Восстановление пароля — `features/restore_password/restore_password_page/presentation/restore_password_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Send request» | `features/restore_password/restore_password_page/presentation/restore_password_page_content.dart:66` | `password_reset.submit_button` | 38 |

#### Диалог ошибки — `features/restore_password/restore_password_page/presentation/dialogs/fail_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Close» | `features/restore_password/restore_password_page/presentation/dialogs/fail_dialog.dart:11` | `password_reset.dialog.close_button` | 296 |

### Восстановление пароля: успех — `features/restore_password/restore_password_success_page/restore_password_success.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Back to sign in»** | `features/restore_password/restore_password_success_page/restore_password_success.dart:49` | **`password_reset.back_to_login_button`** | — |

### Восстановление пароля: новый пароль — `features/restore_password/create_password_page/presentation/create_password_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Save password» («Choose») | `features/restore_password/create_password_page/presentation/widgets/content.dart:90` | `password_reset.save_button` | 41 |
| 2 | **Показать пароль (новый пароль)** | `features/restore_password/create_password_page/presentation/widgets/content.dart:63` | **`password_reset.new_password_visibility_button`** | — |
| 3 | **Показать пароль (подтверждение)** | `features/restore_password/create_password_page/presentation/widgets/content.dart:77` | **`password_reset.confirm_password_visibility_button`** | — |

#### Диалог «ссылка устарела» — `features/restore_password/create_password_page/presentation/dialogs/fail_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Close» | `features/restore_password/create_password_page/presentation/dialogs/fail_dialog.dart:7` | `password_reset.dialog.close_button` | 296 |

### Регистрация: данные аккаунта (нативная) — `features/sign_up/presentation/tabs/user_data/presentation/account_data_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Sign up with Google»** | `features/sign_up/presentation/tabs/user_data/presentation/widgets/social_media.dart:14` | **`registration.google_button`** | — |
| 2 | **«Sign up with Apple» (iOS/macOS)** | `features/sign_up/presentation/tabs/user_data/presentation/widgets/social_media.dart:26` | **`registration.apple_button`** | — |
| 3 | Телефон: контейнер (поле + выбор кода страны) | `features/sign_up/presentation/tabs/user_data/presentation/account_data_page.dart:212` | `registration.phone_input` | 28 |
| 4 | **Подсказка «?» у телефона** | `features/sign_up/presentation/tabs/user_data/presentation/account_data_page.dart:222` | **`registration.phone_tooltip_button`** | — |
| 5 | «Submit» / «Continue» | `features/sign_up/presentation/tabs/user_data/presentation/account_data_page.dart:238` | `registration.submit_button` | 35 |
| 6 | «Privacy policy» (ссылка в тексте, `TextSpan.semanticsIdentifier`) | `features/sign_up/presentation/tabs/user_data/presentation/widgets/policy.dart:55` | `registration.privacy_link` | 34 |
| 7 | «Terms» (ссылка в тексте, `TextSpan.semanticsIdentifier`) | `features/sign_up/presentation/tabs/user_data/presentation/widgets/policy.dart:66` | `registration.terms_link` | 33 |

#### Диалоги регистрации (`semanticsIdPrefix: 'registration.dialog'`)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Уже зарегистрирован: «Cancel» | `features/sign_up/presentation/tabs/user_data/presentation/widgets/already_registered_dialog.dart:7` | `registration.dialog.cancel_button` | 295 |
| 2 | Уже зарегистрирован: «Sign in» | `features/sign_up/presentation/tabs/user_data/presentation/widgets/already_registered_dialog.dart:7` | `registration.dialog.confirm_button` | 294 |
| 3 | Ошибка регистрации: «Close» | `features/sign_up/presentation/tabs/user_data/presentation/widgets/registration_failed_dialog.dart:13` | `registration.dialog.close_button` | 296 |
| 4 | Ошибка подписи: «OK» | `features/sign_up/presentation/tabs/user_data/presentation/widgets/registration_signature_failed_dialog.dart:7` | `registration.dialog.confirm_button` | 294 |

### Регистрация (WebView, по remote config) — `features/sign_up/presentation/webview_sign_up_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Close» (нативный крестик поверх WebView) | `features/sign_up/presentation/webview_sign_up_page.dart:84` | `navigation.close_button` | 44 |
| 2 | Ошибка регистрации: «Close» (`RegistrationFailedDialog`) | `features/sign_up/presentation/dialogs/registration_failed_dialog.dart:16` | `registration.dialog.close_button` | 296 |

### Регистрация: OTP по email — `features/sign_up/pages/confirm_email/presentation/confirm_email_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Resend code» / обратный отсчёт (id зависит от состояния таймера) | `features/sign_up/pages/confirm_email/presentation/widgets/confirm_email_button.dart:32` | `otp.resend_button` / `otp.resend_timer` | 22 / 23 |
| 2 | Диалог ошибки: «Close» (AlertDialog) | `features/sign_up/pages/confirm_email/presentation/confirm_email_page.dart:139` | `otp.dialog.close_button` | 296 |

### Регистрация: добавление телефона — `features/sign_up/presentation/tabs/add_phone_tab/presentation/add_phone_tab.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Back» (явный `BackButton` в AppBar, делает logout) | `features/sign_up/presentation/tabs/add_phone_tab/presentation/add_phone_tab.dart:73` | `navigation.back_button` | 43 |
| 2 | **Телефон: контейнер (поле + код страны)** | `features/sign_up/presentation/tabs/add_phone_tab/presentation/add_phone_tab.dart:95` | **`add_phone.phone_input`** | — |
| 3 | **«Submit» («Choose»)** | `features/sign_up/presentation/tabs/add_phone_tab/presentation/add_phone_tab.dart:103` | **`add_phone.submit_button`** | — |
| 4 | Диалоги «неверный телефон» / ошибка: «Close» | `.../add_phone_tab/presentation/dialogs/empty_phone.dart:8`, `.../dialogs/error.dart:11` | `add_phone.dialog.close_button` | 296 |

### Регистрация: данные ученика (запись на пробный) — `features/sign_up/presentation/tabs/student_data/student_data_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Подсказка «?» у типа учителя** | `features/sign_up/presentation/tabs/student_data/student_data_page.dart:216` | **`student_data.teacher_type_tooltip_button`** | — |
| 2 | **Дата урока (поле-селектор, открывает диалог)** | `features/sign_up/presentation/tabs/student_data/student_data_page.dart:259` | **`student_data.trial_day_selector`** | — |
| 3 | **Время урока (поле-селектор, открывает диалог)** | `features/sign_up/presentation/tabs/student_data/student_data_page.dart:295` | **`student_data.trial_time_selector`** | — |
| 4 | **«Book the lesson»** | `features/sign_up/presentation/tabs/student_data/student_data_page.dart:334` | **`student_data.book_lesson_button`** | — |
| 5 | Ошибка OTP: «Close» (`RegistrationFailedDialog`) | `features/sign_up/presentation/dialogs/registration_failed_dialog.dart:16` | `registration.dialog.close_button` | 296 |

#### Диалог выбора дня — `features/sign_up/presentation/dialogs/slot_pick/widgets/trial_day_pick_dialog/trial_day_pick_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **День (ключ — дата `yyyy-MM-dd` с сервера)** | `...trial_day_pick_dialog.dart:81` | **`trial_day_pick.day_item.<date>`** | — |
| 2 | «Retry» (тап для обновления) | `...trial_day_pick_dialog.dart:97` | `trial_day_pick.retry_button` | 290 |

#### Диалог выбора времени — `features/sign_up/presentation/dialogs/slot_pick/widgets/trial_slot_pick_dialog/trial_slot_pick_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Слот (ключ — `start_time` слота с сервера, ISO)** | `...trial_slot_pick_dialog.dart:91` | **`trial_slot_pick.slot_item.<start_time>`** | — |
| 2 | «Retry» (тап для обновления) | `...trial_slot_pick_dialog.dart:105` | `trial_slot_pick.retry_button` | 290 |

### Регистрация: слот уже занят (повторный выбор) — `features/sign_up/pages/slot_retry/slot_retry_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Таймзона (тап, сейчас без действия)** | `features/sign_up/pages/slot_retry/slot_retry_page_content.dart:219` | **`slot_retry.timezone_button`** | — |
| 2 | **Дата (поле-селектор)** | `features/sign_up/pages/slot_retry/slot_retry_page_content.dart:124` | **`slot_retry.trial_day_selector`** | — |
| 3 | **Время (поле-селектор)** | `features/sign_up/pages/slot_retry/slot_retry_page_content.dart:163` | **`slot_retry.trial_time_selector`** | — |
| 4 | **«Next»** | `presentation/widgets/register_bottom_panel.dart:24` | **`slot_retry.next_button`** | — |
| 5 | **«I have a question» (чат поддержки)** | `presentation/widgets/register_bottom_panel.dart:33` | **`slot_retry.ask_question_link`** | — |

Диалоги дня и времени здесь те же, что выше (`trial_day_pick.*`, `trial_slot_pick.*`).

### Регистрация: успех — `features/sign_up/pages/success/register_success_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Add to calendar»** | `features/sign_up/pages/success/register_success_page.dart:91` | **`register_success.add_to_calendar_button`** | — |
| 2 | **«Proceed»** | `features/sign_up/pages/success/register_success_page.dart:124` | **`register_success.proceed_button`** | — |

### Главная: блок «пробный урок записан» — `features/onboarding_trial_lesson/presentation/widget/onboarding_trial_lesson_widget.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Таб ученика (если пробных уроков несколько; ключ — student.id)** | `features/onboarding_trial_lesson/presentation/widget/onboarding_trial_lesson_widget.dart:138` | **`trial_onboarding.student_tab.<studentId>`** | — |
| 2 | Карточка урока (контейнер) | `.../widget/teacher_trial_lesson_card.dart:64`, `.../widget/china_trial_lesson_card.dart:61` | `home.next_lesson_card` | 74 |
| 3 | **Аватар учителя → профиль** | `.../widget/teacher_trial_lesson_card.dart:89`, `.../widget/china_trial_lesson_card.dart:123` | **`trial_onboarding.teacher_avatar_button`** | — |
| 4 | Меню «…» урока (открывает ScheduleBottomSheet) | `.../widget/teacher_trial_lesson_card.dart:144`, `.../widget/china_trial_lesson_card.dart:150` | `lesson.more_button` | 102 |
| 5 | «Join lesson» | `.../widget/teacher_trial_lesson_card.dart:164`, `.../widget/china_trial_lesson_card.dart:186` | `home.join_lesson_button` | 78 |
| 6 | **«Add to calendar»** | `.../widget/add_to_calendar_button.dart:36` | **`trial_onboarding.add_to_calendar_button`** | — |
| 7 | Секция подготовки к уроку (контейнер) | `.../widget/guide_step_list.dart:53`, `.../widget/alternative_guide/alternative_guide_step_list.dart:94` | `home.preparation_section` | 68 |
| 8 | Шаг «Kids area» — карточка (контейнер, сам тапается) | `.../widget/guide_step_list.dart:102`, `:145` | `home.kids_content_card` | 70 |
| 9 | Ссылка «play your first game» | `.../widget/guide_step_list.dart:104`, `:147`; `.../alternative_guide/alternative_guide_step_list.dart:56` | `home.first_game_link` | 69 |
| 10 | Шаг «видео о первом уроке» (контейнер) | `.../widget/guide_step_list.dart:72`, `:181` | `home.first_lesson_video_section` | 71 |
| 11 | **Шаг «материалы урока» (контейнер)** | `.../widget/guide_step_list.dart:84`, `:193` | **`home.lesson_materials_section`** | — |
| 12 | **«Take a tour» (альтернативный гайд)** | `.../widget/alternative_guide/explore_your_classroom.dart:32` | **`trial_onboarding.take_tour_button`** | — |
| 13 | **«Set up camera and microphone» (альтернативный гайд)** | `.../widget/alternative_guide/alternative_guide_step_list.dart:70` | **`trial_onboarding.setup_camera_mic_link`** | — |
| 14 | **Скопировать WeChat ID (China)** | `.../widget/china_learning_advisor_block.dart:53` | **`trial_onboarding.copy_wechat_id_button`** | — |
| 15 | **Jr App: кнопка App Store** | `.../widget/jr_app_banner.dart:44` | **`trial_onboarding.jr_app_store_button`** | — |
| 16 | **Jr App: кнопка Google Play** | `.../widget/jr_app_banner.dart:54` | **`trial_onboarding.jr_google_play_button`** | — |

### Родительский контроль (parental gate, overlay) — `features/parental_gate/presentation/parental_gate_overlay.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Close»** | `features/parental_gate/presentation/parental_gate_overlay.dart:91` | **`parental_gate.close_button`** | — |
| 2 | **Клавиша цифры / удаления (ключ — цифра или `delete`)** | `features/parental_gate/presentation/parental_gate_overlay.dart:270` | **`parental_gate.key_item.<0-9\|delete>`** | — |

### Согласие Google Analytics (шторка) — `features/google_analytics_consent/presentation/google_analytics_consent_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Accept all»** (оба режима) | `features/google_analytics_consent/presentation/widgets/google_analytics_consent_bottom_sheet.dart:107`, `:113` | **`ga_consent.accept_all_button`** | — |
| 2 | **«Customize»** | `...google_analytics_consent_bottom_sheet.dart:119` | **`ga_consent.customize_button`** | — |
| 3 | **«Reject all»** | `...google_analytics_consent_bottom_sheet.dart:125` | **`ga_consent.reject_all_button`** | — |
| 4 | **«Save choices»** | `...google_analytics_consent_bottom_sheet.dart:101` | **`ga_consent.save_choices_button`** | — |
| 5 | **Переключатель «analytics storage»** | `...google_analytics_consent_bottom_sheet.dart:62` | **`ga_consent.analytics_storage_switch`** | — |
| 6 | **Переключатель «ad storage»** | `...google_analytics_consent_bottom_sheet.dart:71` | **`ga_consent.ad_storage_switch`** | — |
| 7 | **Переключатель «ad user data»** | `...google_analytics_consent_bottom_sheet.dart:80` | **`ga_consent.ad_user_data_switch`** | — |
| 8 | **Переключатель «ad personalization»** | `...google_analytics_consent_bottom_sheet.dart:89` | **`ga_consent.ad_personalization_switch`** | — |

### Пользователь из Китая (шторка) — `features/push_china_user/presentation/widgets/china_user_bottom_sheet.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Download China app»** | `features/push_china_user/presentation/widgets/china_user_bottom_sheet.dart:58` | **`china_user.download_button`** | — |
| 2 | **«Open in browser»** | `features/push_china_user/presentation/widgets/china_user_bottom_sheet.dart:70` | **`china_user.open_browser_button`** | — |

### Общие виджеты раздела
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **`PolicyWidget` (ссылка на privacy/terms; сейчас используется в `features/subscription_change/widgets/common/privacy_policy_line.dart`)** | `common/presentation/widgets/policy/presenter/policy.dart:34` | **`policy.<privacy\|terms_and_conditions\|terms_and_conditions_monthly>_link`** (или новый параметр `semanticsId`) | — |
| 2 | **`AuthFailedDialog`: «Request again» (класс сейчас нигде не используется)** | `common/presentation/widgets/auth/auth_failed_dialog.dart:20` | **`auth.dialog.confirm_button`** | — |
| 3 | `PhoneInput`: новый необязательный параметр `semanticsId` (контейнер вокруг поля и выбора страны) | `common/presentation/widgets/phone_input/phone_input.dart` | — | 16 / 28 |

### Примечания
- Кнопки диалогов на `BaseDialog` получают id через `DialogParams.semanticsIdPrefix` (вместе с `DialogAction.semanticsName`), см. «BaseDialog: автоматические id для всех наследников».
- Кнопки показа пароля помечены через параметр `visibilityButtonSemanticsId` у `TitleBorderTextField` и `PasswordEditText`: `login.password_visibility_button`, `password_reset.new_password_visibility_button`, `password_reset.confirm_password_visibility_button`.
- `otp.resend_button` и `otp.resend_timer` — это одна и та же кнопка. Пока идёт отсчёт (кнопка неактивна, в тексте таймер), у неё id `otp.resend_timer`, после отсчёта — `otp.resend_button`.
- Ссылки внутри текста (`login.sign_up_link`, `registration.privacy_link`, `registration.terms_link`) — это `TextSpan.semanticsIdentifier` (Flutter 3.41): узел ссылки получает id, окружающий текст в него не входит.
- `home.next_lesson_card` / `home.join_lesson_button` / `home.preparation_section` есть и на дашборде пробного урока. При нескольких пробных уроках неактивные вкладки лежат в `IndexedStack` и в дерево semantics не попадают, поэтому дублей нет. Тот же `home.next_lesson_card` стоит на обычной карточке следующего урока; на одном экране они вместе не показываются (`dashboard_scroll_view.dart:333`), но стоит перепроверить на устройстве.
- `trial_day_pick.day_item.<date>` использует дату с сервера (`2026-10-21`), `trial_slot_pick.slot_item.<start_time>` — ISO `start_time` слота. Это не индексы и не текст.
- Ключ `trial_onboarding.student_tab.<studentId>` — это `student.id` (может быть `null`, тогда id получит суффикс `null`).
- `slot_retry.timezone_button`: у `GestureDetector` пустой `onTap` (код закомментирован), поэтому id стоит на элементе без действия.
- Что не нашлось или пропущено намеренно:
  - текстовые поля (не размечаются): 9, 10, 20, 26, 27, 30, 37, 39, 40;
  - текстовые метки (не размечаются): 19, 25, 36, 42;
  - `otp.verify_button` (21): отдельной кнопки нет, код отправляется автоматически, когда введены все 6 цифр (`Pinput.onCompleted`);
  - `registration.terms_checkbox` и `registration.marketing_checkbox` (31, 32): в нативной регистрации чекбоксов нет, согласие — это текст с двумя ссылками;
  - `features/splash_page`, `features/easy_start` (только WebView, без нативных кнопок), `presentation/widgets/pin_put` (поле ввода; виджет `PinPut` нигде не используется): кнопок нет.

## Навигация, меню профиля, главная, расписание

Пути относительно `packages/shared/lib`.

### Нижняя навигация — `presentation/page/parent/presentation/parent_content_page.dart`
`Semantics(identifier:)` стоит вокруг иконки `BottomNavigationBarItem` и сливается в узел пункта таба (там, где сейчас content-desc "Dashboard Tab 1 of 5").

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Таб Dashboard (Home) | `presentation/page/parent/presentation/parent_content_page.dart:215` | `navigation.home_tab` | 45 |
| 2 | Таб Schedule (календарь) | `…/parent_content_page.dart:216` | `navigation.schedule_tab` | 46 |
| 3 | **Таб Kids area** | `…:217` | **`navigation.kids_area_tab`** | — (47 «Star»?) |
| 4 | **Таб Achievements** | `…:218` | **`navigation.achievements_tab`** | — (48 «Medal»?) |
| 5 | **Таб Monthly challenge** | `…:219` | **`navigation.monthly_challenge_tab`** | — |
| 6 | **Таб Summer challenge** | `…:220` | **`navigation.summer_challenge_tab`** | — (49 «Sun»?) |
| 7 | **Таб Winter challenge** | `…:221` | **`navigation.winter_challenge_tab`** | — |
| 8 | **Таб Bonuses** | `…:222` | **`navigation.bonuses_tab`** | — |
| 9 | **Таб Referral** | `…:223` | **`navigation.referral_tab`** | — |
| 10 | **Таб Support (чат)** | `…:224` | **`navigation.support_tab`** | — (50 «Chat») |

### Главная (Dashboard) — `presentation/page/parent/presentation/widgets/dashboard/dashboard_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Аватар/инициалы ("Н-"), открывает меню профиля | `…/dashboard/widgets/dashboard_app_bar.dart:39` | `navigation.profile_menu_button` | 51 |
| 2 | Колокольчик App Inbox | `features/app_inbox/presentation/widgets/app_inbox_button.dart:24` | `navigation.notifications_button` | 52 |
| 3 | Карточка ближайшего урока (контейнер ListTile) | `…/upcoming_class/widgets/legacy_class.dart:89`, `…/group_class.dart:23` | `home.next_lesson_card` | 74 |
| 4 | Меню «⋮» у урока | `legacy_class.dart:115`, `group_class.dart:37` | `lesson.more_button` | 102 |
| 5 | «Join lesson» | `legacy_class.dart:133`, `group_class.dart:132` | `home.join_lesson_button` | 78 |
| 6 | **Таб «Before lesson» в карточке** | `legacy_class.dart:28` | **`home.next_lesson_before_lesson_tab`** | — |
| 7 | **Таб «Materials» в карточке** | `legacy_class.dart:34` | **`home.next_lesson_materials_tab`** | — |
| 8 | **Синхронизация с Google Calendar** | `legacy_class.dart:217`, `group_class.dart:150` | **`home.calendar_sync_button`** | — |
| 9 | **«Add to calendar»** | `legacy_class.dart:241` | **`home.add_to_calendar_button`** | — |
| 10 | «Book a new class» | `…/upcoming_classes_loaded/widgets/common/dashboard_book_lesson_button.dart:26` | `home.book_lesson_button` | 79 |
| 11 | Селектор ученика (контейнер TabBar, multi-child) | `…/multi_next_class/multi_child_content.dart:94` | `home.student_selector` | 72 |
| 12 | Таб ученика | `multi_child_content.dart:207` | `student_selector.student_item.<student.id>` | 85 |
| 13 | «Top up now» (action-баннер и TopUp-баннер, взаимоисключающие) | `…/dashboard_action_button/dashboard_action_button.dart:54`, `…/dashboard_subscription/widgets/top_up_subscription_banner.dart:104` | `home.top_up_balance_button` | 81 |
| 14 | **«Book class» (есть незабронированные уроки)** | `dashboard_action_button.dart:60` | **`home.book_unbooked_lessons_button`** | — |
| 15 | **«Start earlier»** | `…/dashboard_action_button/widgets/action_start_earlier.dart:34` | **`home.start_earlier_button`** | — |
| 16 | «Book trial» (пробный урок не состоялся) | `…/dashboard_trial_failed.dart:67` | `home.book_trial_button` | 67 |
| 17 | **Карточка подписки (контейнер)** | `…/dashboard_subscription/dashboard_subscription.dart:196` | **`home.subscription_card`** | — |
| 18 | **«See more» (подписка)** | `dashboard_subscription.dart:152` | **`home.subscription_see_more_button`** | — |
| 19 | Остаток уроков (ячейка) | `…/widgets/item_subscription_classes.dart:37` | `home.lesson_balance_value` | 73 |
| 20 | **Ячейка даты подписки** | `…/widgets/item_subscription_date.dart:29` | **`home.subscription_date_item`** | — |
| 21 | **Ячейка бонусов** | `…/item_subscription_bonus/item_subscription_bonus.dart:77` | **`home.subscription_bonus_item`** | — |
| 22 | **Карточка групповой подписки** | `…/widgets/dashboard_group_subscription.dart:26` | **`home.group_subscription_card`** | — |
| 23 | **Строка индивидуальной подписки (multi)** | `…/widgets/dashboard_multi_subscription.dart:111` | **`home.individual_subscription_item`** | — |
| 24 | **Строка групповой подписки (multi)** | `dashboard_multi_subscription.dart:135` | **`home.group_subscription_item`** | — |
| 25 | **Строка курса (multi)** | `dashboard_multi_subscription.dart:150` | **`home.course_subscription_item.<course.slug>`** | — |
| 26 | «Buy subscription» (membership: нет подписки / истекла) | `…/membership/no_subscription_banner.dart:37`, `…/membership/additional_subs_info.dart:87` | `home.buy_subscription_button` | 80 |
| 27 | **«Buy subscription» после пробного** | `…/widgets/after_trial_no_subscription_banner.dart:39` | **`home.after_trial.buy_subscription_button`** | — |
| 28 | **«View details» (membership)** | `…/membership/dashboard_membership_subscription.dart:77` | **`home.membership_view_details_button`** | — |
| 29 | **«Book more lessons» (membership)** | `additional_subs_info.dart:30` | **`home.membership_book_more_button`** | — |
| 30 | **Кнопка «paused» (membership)** | `additional_subs_info.dart:42` | **`home.membership_paused_button`** | — |
| 31 | **Кнопка «future pause»** | `additional_subs_info.dart:63` | **`home.membership_future_pause_button`** | — |
| 32 | **Кнопка «canceled»** | `additional_subs_info.dart:76` | **`home.membership_canceled_button`** | — |
| 33 | **Кнопка «failed auto payment»** | `additional_subs_info.dart:99` | **`home.membership_failed_payment_button`** | — |
| 34 | **SP-баннер (контейнер)** | `…/dashboard/widgets/sp_banner.dart:60` | **`home.sp_banner`** | — (82?) |
| 35 | **SP-баннер: закрыть** | `sp_banner.dart:85` | **`home.sp_banner.close_button`** | — |
| 36 | **SP-баннер: «Join»** | `sp_banner.dart:113` | **`home.sp_banner.join_button`** | — (83?) |
| 37 | **Summer camp: закрыть** | `…/summer_camp/presenter/summer_camp.dart:60` | **`home.summer_camp.close_button`** | — |
| 38 | **Summer camp: баннер** | `summer_camp.dart:77` | **`home.summer_camp.banner_card`** | — |
| 39 | **Summer camp: «Login»** | `summer_camp.dart:164` | **`home.summer_camp.login_button`** | — |
| 40 | **Элемент ленты активности (контейнер)** | `…/dashboard_activity_item/item_activity.dart:116` | **`home.activity_item.<activity.id>`** | — |
| 41 | **Лента: повтор (retry)** | `…/dashboard_activity_feed.dart:226` (параметр `RefreshErrorWidget.semanticsId`) | **`home.activity_feed.retry_button`** | 290 |
| 42 | **Активность «урок отменён»: «book a new class»** | `…/widgets/activity_cancelled_class.dart:43` | **`home.activity_book_new_class_button`** | — |
| 43 | **Активность «первый урок»: «book»** | `…/widgets/book_first_lesson.dart:70` | **`home.activity_book_first_lesson_button`** | — |
| 44 | **Карточка завершения уровня (контейнер)** | `…/widgets/level_completion.dart:26` | **`home.level_completion_card.<activity.id>`** | — |
| 45 | **Карточка завершения юнита (контейнер)** | `…/widgets/unit_completion.dart:44` | **`home.unit_completion_card.<activity.id>`** | — |
| 46 | **Реферальный share-баннер (контейнер / info / share)** | `…/widgets/share_social_media_program.dart:122/234/253` | **`<prefix>.banner`, `<prefix>.info_button`, `<prefix>.share_button`**, где prefix = `home.activity_share_referral` / `home.level_completion_share_referral` / `home.unit_completion_share_referral` (по умолчанию `share_referral`) | — |

#### Диалог «Start earlier» — `…/dashboard_action_button/widgets/dialog_start_earlier.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Go ahead» / «Cancel» | `dialog_start_earlier.dart:24` (`semanticsIdPrefix`) | `home.start_earlier_dialog.confirm_button` / `.cancel_button` | 294/295 |
| 2 | Диалог ошибки: «Cancel» | `…/widgets/dialog_action_fail.dart` (`semanticsIdPrefix`) | `home.start_earlier_error_dialog.cancel_button` | 295 |

#### Меню профиля (end drawer) — `…/dashboard/widgets/drawer/dashboard_drawer.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Закрыть меню (крестик, телефон)** | `…/drawer/widgets/header.dart:48` | **`profile_menu.close_button`** | — (44) |
| 2 | Ученик в списке | `…/drawer/widgets/item_student.dart:44`, id из `students.dart:64` | `profile_menu.student_item.<student.id>` | 54 |
| 3 | «New student» | `…/drawer/widgets/students.dart:8` | `profile_menu.add_student_button` | 55 |
| 4 | «Account» | `…/drawer/widgets/menu.dart:23` | `profile_menu.account_button` | 56 |
| 5 | «Subscription» (ListTile из WidgetProvider) | `menu.dart:64` | `profile_menu.subscription_button` | 57 |
| 6 | **«Bonuses»** | `menu.dart:84` | **`profile_menu.bonuses_button`** | — |
| 7 | **«Courses catalog»** | `menu.dart:208` | **`profile_menu.courses_button`** | — |
| 8 | «Library» | `menu.dart:102` | `profile_menu.library_button` | 58 |
| 9 | «Speaking practice» (групповые занятия) | `menu.dart:119` | `profile_menu.speaking_practice_button` | 59 |
| 10 | **«Ambassador»** | `menu.dart:148` | **`profile_menu.ambassador_button`** | — |
| 11 | «Help» | `menu.dart:175` | `profile_menu.help_button` | 60 |
| 12 | «Log out» | `…/drawer/widgets/log_out.dart:9` | `profile_menu.logout_button` | 61 |
| 13 | Реферальный баннер (контейнер) | `…/drawer/widgets/referral_banner.dart:45` | `profile_menu.referral_banner` | 62 |
| 14 | Реферальная кнопка «Go» | `referral_banner.dart:73` | `profile_menu.referral_button` | 63 |

### Расписание (Schedule) — `presentation/page/parent/presentation/widgets/schedule_new/schedule_new_page.dart` (телефон/планшет)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Переключатель Upcoming/Past (контейнер) | `…/schedule_new/phone/schedule_phone.dart:224`, `…/tablet/schedule_tablet.dart:191` | `schedule.lesson_period_selector` | 89 |
| 2 | **Таб Upcoming / Past** | там же (`tabSemanticsIds`), применяется в `…/widgets/schedule_tab_bar.dart:139` | **`schedule.upcoming_tab` / `schedule.past_tab`** | — |
| 3 | Карточка урока (контейнер вокруг ItemSchedule) | `…/tabs/future/widgets/month_section.dart:83` | `schedule.lesson_card.<class.id>` | 94 |
| 4 | «Book lessons» (телефон и планшет) | `…/schedule_new/book_lesson_button.dart:58`, `:165` | `schedule.book_lessons_button` | 95 |
| 5 | **Синхронизация с Google Calendar** | `…/widgets/schedule_google_calendar_sync.dart:32` | **`schedule.calendar_sync_button`** | — |
| 6 | **Повтор при ошибке подгрузки** | `…/tabs/future/widgets/future_classes_loading_more_failed_state_widget.dart:11` | **`schedule.load_more_retry_button`** | 290 |
| 7 | **Закрыть баннер «перенесено»** | `…/widgets/reschedule_result_banner.dart:41` | **`schedule.reschedule_banner.close_button`** | — |
| 8 | **«Group schedule» (устарело, не используется)** | `…/widgets/schedule_app_bar_action.dart:52` | **`schedule.group_schedule_button`** | — |

#### Шторка «Book» — `…/schedule_new/widgets/book_bottom_sheet.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Индивидуальный урок** | `book_bottom_sheet.dart:58` (кнопка: `book_bottom_sheet_button.dart:57`) | **`schedule.book_sheet.individual_button`** | — |
| 2 | **Групповое занятие** | `book_bottom_sheet.dart:70` | **`schedule.book_sheet.group_button`** | — |
| 3 | **Курс** | `book_bottom_sheet.dart:81` | **`schedule.book_sheet.course_button.<course.slug>`** | — |

### Входящие (App Inbox) — `features/app_inbox/presentation/app_inbox_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Back» (NewAppBar) | `common/presentation/widgets/navigation/new_app_bar.dart:32` | `navigation.back_button` | 43 |
| 2 | **Сообщение** | `features/app_inbox/presentation/widgets/app_inbox_message_tile.dart:16` | **`app_inbox.message_item.<message.id>`** | — |

### Общие виджеты раздела
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Back» в `NewAppBar` (на всех экранах, где он используется) | `common/presentation/widgets/navigation/new_app_bar.dart:32` | `navigation.back_button` | 43 |
| 2 | «Back» в `SimpleAppBar` | `presentation/widgets/app_bar.dart:38` | `navigation.back_button` | 43 |
| 3 | StudentTabBarSelector (контейнер; параметр `semanticsId`, по умолчанию `student_selector`) | `common/presentation/widgets/student_tab_bar_selector.dart:128` | `student_selector` | — |
| 4 | Таб ученика в StudentTabBarSelector | `student_tab_bar_selector.dart:186` | `student_selector.student_item.<student.id>` | 85 |
| 5 | **Прогресс ученика (achievements)** | `presentation/widgets/student_progress.dart:71` | **`achievements.student_progress_button`** | — |
| 6 | **Прогресс ученика: повтор** | `student_progress.dart` (`SmallRefreshErrorWidget.semanticsId`) | **`achievements.student_progress_retry_button`** | 290 |
| 7 | **Ссылка на чат поддержки (FirstLessonTutorial: перед первым уроком, успешная регистрация)** | `presentation/widgets/first_lesson_tutorial.dart:182` | **`first_lesson_tutorial.support_chat_link`** | — |
| 8 | **WKA-баннер «Join» (экран завершённого урока)** | `features/banners/sp_banners/presentation/widgets/payload.dart:31` | **`wka_banner.join_button`** | — |
| 9 | Промокод «Apply» (экран смены подписки) | `…/dashboard-buy-subscription/dashboard-buy-item/widgets/promocode.dart:144` | `purchase_summary.apply_promo_button` | 232 |
| 10 | **Промокод «Reset»** | `promocode.dart:163` | **`purchase_summary.reset_promo_button`** | — |
| 11 | Промокод «Remove» | `promocode.dart:272` | `payment.remove_promo_button` | 253 |

### Примечания
- Соответствие BottomTabElement и названий QA: dashboard = Home, schedule = Calendar. Вероятное соответствие для остальных: kidsArea = «Star», achievements = «Medal», summerChallenge = «Sun» (зимой winterChallenge, в остальное время monthlyChallenge), support = «Chat». Видимы до 5 табов: набор зависит от конфига и региона. bonuses/referral показываются только при соответствующих флагах.
- Аватар «Н-» — `DashboardUserLogo` в шапке dashboard. Он открывает end drawer (меню профиля), поэтому получил `navigation.profile_menu_button`. Тот же логотип в шапке меню не нажимается и не тегирован.
- Крестик меню профиля — `profile_menu.close_button`. `navigation.close_button` (№44) получают стандартные кнопки закрытия в `AppBar` (см. «Централизованные ID»).
- `NovakidTabBar` получил необязательные `semanticsId` (контейнер) и `tabSemanticsIds` (`List<String>?`, по порядку табов; id ставится внутри каждого Tab). Вкладки на экране информации о балансе: `balance_info.subscription_tabs` (контейнер) и `balance_info.subscription_tab.<id>`; в запросе слота — `ask_slot.mode_selector`, `ask_slot.weekly_tab`, `ask_slot.one_time_tab`.
- `ShareSocialMediaProgram` получил `semanticsIdPrefix` (по умолчанию `share_referral`). Места вызова передают свои префиксы: `level_completion.share_referral`, `unit_completion.share_referral`, `class_details_share.highlight` / `class_details_share.screenshot`; `.withBorder` пробрасывает префикс.
- `StudentTabBarSelector` получил `semanticsId` (по умолчанию `student_selector`). Экран подписки передаёт `subscription.student_selector`, бронирование — `booking.student_selector`.
- Элементы без технического ключа: `home.next_lesson_card`, `lesson.more_button`, `home.join_lesson_button` не имеют ключа. В multi-child виден только один ученик, потому что `IndexedStack` отдаёт в semantics только активный child.
- Значения и лейблы (`profile_menu.parent_name` 53, `profile_menu.app_version_label` 64, `home.next_lesson_date/time/teacher_name` 75–77, `student_selector.student_name` 86, `student_selector.selected_indicator` 87, `schedule.current_period_label` 92) не размечены: это обычные текстовые метки. Исключение — `home.lesson_balance_value` (73): это ячейка с GestureDetector.
- В этом разделе нет UI для: `schedule.previous_period_button` / `next_period_button` / `calendar_day_item` (90, 91, 93: навигации по неделям/дням нет), `home.challenge_progress_value` (84), `student_selector.add_student_button` (88; есть только `profile_menu.add_student_button`), `home.booking_heading`, `empty_lesson_card` (отдельного элемента нет), `first_game_link`, `kids_content_card`, `first_lesson_video_section`, `preparation_section` (65–71; размечены в блоке пробного урока, см. «Главная: блок «пробный урок записан»» в разделе «Авторизация, регистрация, онбординг»).
- В `sp_web_view.dart` и `bonuses_dashboard_page.dart` нет нативных кнопок (только WebView), тегировать нечего.
- Промокод (`promocode.dart`) используется на экране subscription change. Для Remove взят `payment.remove_promo_button` (№253) согласно задаче.
- Там, где обёртка стоит снаружи вокруг виджета, который тегирует себя сам (JoinLessonButton и т.п.), ожидается, что сработает внешний id. На устройстве это не проверялось.

## Уроки и бронирование

Пути относительно `packages/shared/lib`. Номер строки указывает на место обёртки `SemanticsId` или строку `id:`; из-за многострочных обёрток он может отличаться на ±3.
Кнопки диалогов на `BaseDialog` получают id через `DialogParams.semanticsIdPrefix`. Получается `<prefix>.confirm_button` для primary/destructive и `<prefix>.cancel_button` для второй кнопки. Если задан `semanticsName`, получается `<prefix>.<semanticsName>`. Кнопка закрытия (showCloseButton) получает `<prefix>.close_button`.

### Выбор учителя (бронирование) — `presentation/page/class_add/presentation/class_add_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Фильтры (иконка options в AppBar; QA сейчас ищет её по XPath ImageView[2]) | `presentation/page/class_add/presentation/widgets/class_add_scaffold.dart:69` | `booking.filters_button` | 122 |
| 2 | **Избранные учителя (иконка в AppBar)** | `.../class_add_scaffold.dart:42` | **`booking.favorite_teachers_button`** | — |
| 3 | Выбор ученика (StudentTabBarSelector, параметр `semanticsId`) | `.../widgets/fast_filter.dart:33` | `booking.student_selector` | 117 |
| 4 | **Удалить чип фильтра времени** | `.../widgets/fast_filter.dart:109` | **`booking.remove_filter_chip_button.${range.start.millisecondsSinceEpoch}`** | — |
| 5 | **Сбросить фильтры («Clear»)** | `.../widgets/fast_filter.dart:123` | **`booking.reset_filters_button`** | — |
| 6 | Карточка учителя (контейнер) | `features/class_add/presentation/widget/teacher_card.dart:44` | `teachers.teacher_card.${teacher.id}` | 139 |
| 7 | «Read more» (открыть профиль) | `features/class_add/presentation/widget/teacher_card.dart:67` | `teacher.profile_button.${teacher.id}` | 143 |
| 8 | «Book lesson» на карточке | `features/class_add/presentation/widget/teacher_card.dart:118` | `teacher.book_button.${teacher.id}` | 144 |
| 9 | **Аватар учителя (открывает профиль)** | `features/class_add/presentation/widget/teacher_card_avatar.dart:17` | **`teacher.avatar_button.${teacher.id}`** | — |
| 10 | **Подарок учителю (иконка на карточке)** | `features/gift_teacher/presentation/widgets/gift_teacher.dart:50` | **`teacher.gift_button.${widget.teacherId}`** | — |

#### Диалоги экрана
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Подтверждение premium/standard: «Continue» / «Cancel» | `presentation/page/class_add/presentation/widgets/confirm_booking_dialog.dart:21` | `booking.confirm_dialog.confirm_button` / `booking.confirm_dialog.cancel_button` | 294/295 |
| 2 | Ошибка загрузки: «Retry» / «Back to dashboard» | `.../class_add_error_dialog.dart:32` | `booking.error_dialog.confirm_button` / `booking.error_dialog.cancel_button` | 294/295 |
| 3 | Диалог с выбором: «Confirm» / «Decline» | `.../class_add_error_with_choice_dialog.dart:34` | `booking.choice_dialog.confirm_button` / `booking.choice_dialog.cancel_button` | 294/295 |
| 4 | **Радио-вариант в диалоге выбора** | `.../class_add_error_with_choice_dialog/choice_variant.dart:81` | **`booking.choice_dialog.variant_option.$value`** (значение 0/1) | — |
| 5 | Ошибка пробного урока: «Contact support» / «Close» | `.../lesson_creation_error_dialog.dart:14` | `booking.lesson_creation_error_dialog.confirm_button` / `booking.lesson_creation_error_dialog.close_button` | 294/296 |

#### Подарок учителю (диалог)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Send gift»** | `features/gift_teacher/presentation/widgets/gift_send_teacher.dart:70`, `features/gift_teacher/presentation/gift_feedback_dialog.dart:86` | **`gift_teacher.send_button`** | — |
| 2 | **«Cancel»** | `.../gift_send_teacher.dart:89` | **`gift_teacher.cancel_button`** | — |
| 3 | **«Confirm and send»** | `.../gift_confirmation_content.dart:106` | **`gift_teacher.confirm_button`** | — |
| 4 | **«Close» (успех)** | `.../gift_success_content.dart:53` | **`gift_teacher.close_button`** | — |
| 5 | **Варианты ошибки: кнопка действия / «Got it»** | `.../gift_error_content.dart:102,157,214,265` | **`gift_teacher.not_enough_lessons.action_button`**, **`gift_teacher.limit_reached.got_it_button`**, **`gift_teacher.last_lesson.action_button`**, **`gift_teacher.network_error.got_it_button`** | — |
| 6 | **Parents gate: цифры** | `.../parents_gate.dart:83` | **`parents_gate.number_button.$number`** | — |
| 7 | **Parents gate: закрыть** | `.../parents_gate.dart:126` | **`parents_gate.close_button`** | — |

### Фильтры бронирования — `features/class_add_filter/presentation/class_add_filter.dart`
Группы фильтров: `teacher_level`, `gender`, `accent`, `lesson_time`, `character` (и `student`).

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Apply | `features/class_add_filter/presentation/class_add_filter.dart:269` | `booking_filters.apply_button` | 130 |
| 2 | Clear (AppBar) | `.../class_add_filter.dart:85` | `booking_filters.reset_button` | 131 |
| 3 | Группа фильтра (ExpansionTile, контейнер) | `.../widgets/expansion_tile.dart:32` | `booking_filters.{teacher_level\|gender\|accent\|lesson_time\|character}.container` | 128 |
| 4 | **Заголовок группы (раскрыть/свернуть)** | `.../widgets/expansion_tile.dart:32` | **`booking_filters.<group>.header_button`** | — |
| 5 | Тип учителя | `.../widgets/teacher_levels_selector.dart:23-37` | `booking_filters.teacher_level.option_item.{all\|premium\|standard}` | 129 |
| 6 | Пол | `.../widgets/gender_selector.dart:23-37` | `booking_filters.gender.option_item.{none\|male\|female}` | 129 |
| 7 | Акцент | `.../widgets/accent_selector.dart:23-37` | `booking_filters.accent.option_item.{none\|british\|american}` | 129 |
| 8 | Характер (чекбоксы) | `.../widgets/character_selector.dart:23,36` | `booking_filters.character.option_item.${character.name}` | 129 |
| 9 | Слот времени (InputChip) | `.../widgets/time_range_selector/one_time_tile.dart:55` | `booking_filters.lesson_time.option_item.${range.start.toIso8601String()}` | 129 |
| 10 | **Чекбокс дня** | `.../one_time_tile.dart:36` | **`booking_filters.lesson_time.day_checkbox.<yyyy-MM-dd>`** | — |
| 11 | **Вкладки Weekly / One-time** | `.../time_range_selector/period_selector.dart:51,62` | **`booking_filters.lesson_time.weekly_tab`**, **`booking_filters.lesson_time.one_time_tab`** | — |
| 12 | **Календарь (контейнер TableCalendar)** | `.../time_range_selector/one_time_selector.dart:21` | **`booking_filters.lesson_time.calendar`** | — |
| 13 | **«OK» у пикера времени** | `.../time_range_selector/cupertino_time_picker.dart:56` | **`booking_filters.lesson_time.time_picker_ok_button`** | — |
| 14 | **Выбор ученика (dropdown) и пункты** | `.../widgets/student_selector/student_selector.dart:52` | **`booking_filters.student_selector`**, **`booking_filters.student.option_item.${s.id}`** | — |
| 15 | Диалог ошибки: «Close» | `.../widgets/dialog/fail_dialog.dart:11` | `booking_filters.fail_dialog.close_button` | 296 |

### Карточка / детали урока — `features/class_details/presentation/class_details_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Join» («Enter class») | `features/class_details/presentation/widgets/upcoming_class/widgets/actions_widget.dart:50,139` | `lesson.join_button` | 103 |
| 2 | «Reschedule» | `.../actions_widget.dart:61,154` | `lesson.reschedule_button` | 105 |
| 3 | «Cancel» | `.../actions_widget.dart:72,166` | `lesson.cancel_button` | 106 |
| 4 | «Back» (AppBar), во всех состояниях | `.../upcoming_class/upcoming_class.dart:59`, `.../completed/completed_class.dart:81`, `.../completed/widgets/completed_scaffold.dart:104`, `.../completed/widgets/completed_failed_class.dart:20`, `.../class_details_error_state_widget.dart:21`, `.../class_details_loading_state_widget.dart:12` | `navigation.back_button` | 43 |
| 5 | Перевести / показать оригинал отзыва учителя | `.../class_details_comment.dart:87` | `lesson_feedback.translation_toggle` | 110 |
| 6 | Повторить загрузку | `.../class_details_error_state_widget.dart:35` | `lesson.retry_button` | 290 |
| 7 | **Аватар учителя** | `.../class_details_teacher.dart:27` | **`lesson.teacher_avatar_button`** | — |
| 8 | **Домашнее задание (practise)** | `.../completed/widgets/class_details_homework.dart:37` | **`lesson.homework_button`** | — |
| 9 | **Запись урока (камера в AppBar)** | `.../completed/widgets/completed_scaffold.dart:38` | **`lesson.recording_button`** | — |
| 10 | **Видео-хайлайт (карточка-контейнер)** | `.../class_details_highlight.dart:77` | **`lesson.highlight_video_card`** | — |
| 11 | **Share-баннер хайлайта / скриншота (ShareSocialMediaProgram `semanticsIdPrefix`)** | `.../class_details_highlight.dart:117`, `.../class_details_screenshot.dart:154` | **`class_details_share.highlight.{banner\|info_button\|share_button}`**, **`class_details_share.screenshot.{...}`** | — |

#### Диалоги
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Списание при отмене (AlertDialog): «No» / «Yes» | `.../actions_widget.dart:281,294` | `lesson_cancellation.penalty_dialog.cancel_button` / `lesson_cancellation.penalty_dialog.confirm_button` | 295/294 |
| 2 | Диалог «Before class»: перейти в кабинет ученика | `features/class_details/presentation/widgets/before_class_dialog.dart:20` | `lesson.before_class_dialog.confirm_button` | 294 |

### Шторка действий с уроком (Schedule bottom sheet) — `common/presentation/widgets/reschedule/schedule_bottom_sheet_widget.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Reschedule» (ClassActionItem, перенос) | `features/classes_action/presentation/widgets/class_action_item.dart:29,46` | `lesson.reschedule_button` | 105 |
| 2 | «Cancel» (с бесплатной отменой или списанием) | `features/classes_action/presentation/widgets/class_action_item.dart:29,46` | `lesson.cancel_button` | 106 |
| 3 | **«Add to calendar» (пробный урок)** | `common/presentation/widgets/reschedule/schedule_bottom_sheet_widget.dart:130` | **`lesson.add_to_calendar_button`** | — |
| 4 | **«Add to calendar» (общий виджет, необязательный `semanticsId`)** | `common/presentation/widgets/add_2_calendar/add_2_calendar_button.dart:26` | **`lesson.add_to_calendar_button`** (по умолчанию) | — |

#### Отмена урока (диалоги)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Cancel lesson» (подтверждение разовой отмены) | `features/classes_action/presentation/widgets/dialogs/class_delete_one_time_dialog.dart:138` | `lesson_cancellation.confirm_button` | 115 |
| 2 | «Back» (оставить урок) | `.../class_delete_one_time_dialog.dart:150` | `lesson_cancellation.keep_lesson_button` | 116 |
| 3 | Закрыть (крестик) | `.../class_delete_one_time_dialog.dart:75` | `lesson_cancellation.dialog.close_button` | 296 |
| 4 | Списание: «No» / «Yes» | `.../dialogs/class_cancel_penalty_dialog.dart:22` | `lesson_cancellation.penalty_dialog.cancel_button` / `lesson_cancellation.penalty_dialog.confirm_button` | 295/294 |
| 5 | Причина отмены (отзыв после отмены) | `features/lesson_cancellation_feedback/presenter/widgets/cancellation_feedback.dart:124` | `lesson_cancellation.reason_item.${reason.name}` | 113 |
| 6 | **«Submit» (отзыв)** | `.../cancellation_feedback.dart:155` | **`lesson_cancellation.submit_button`** | — |
| 7 | **Закрыть (отзыв)** | `.../cancellation_feedback.dart:98` | **`lesson_cancellation.close_button`** | — |

### Перенос урока, новый флоу — `features/classes_action/presentation/widgets/class_reschedule_exp_flow_screen.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Панель выбранного слота (SelectedSlotsActionPanel) | `.../class_reschedule_exp_flow_screen.dart:97,117` | префикс `class_reschedule` (id формирует виджет учителя) | — |
| 2 | Диалог подтверждения: «Confirm» / «Cancel» | `.../dialogs/class_reschedule_dialog/dialogs/class_reschedule_confirm_dialog.dart:16` | `reschedule.confirm_dialog.confirm_button` / `reschedule.confirm_dialog.cancel_button` | 294/295 |
| 3 | Диалог ошибки: «Try again» / «Cancel» | `.../dialogs/class_reschedule_failed_dialog.dart:12` | `reschedule.failed_dialog.confirm_button` / `reschedule.failed_dialog.cancel_button` | 294/295 |
| 4 | **Нет слотов: оставить / отменить урок** | `.../dialogs/class_reschedule_no_slots_cancellation_dialog.dart:12` | **`reschedule.no_slots_cancellation_dialog.keep_lesson_button`** / **`reschedule.no_slots_cancellation_dialog.cancel_lesson_button`** | — |
| 5 | Нет слотов: «Cancel» | `.../dialogs/class_reschedule_no_slots_dialog.dart:12` | `reschedule.no_slots_dialog.cancel_button` | 295 |
| 6 | Ошибка переноса: «Support» / «Close» | `presentation/page/class_move/presentation/widgets/class_move_operation_failed_dialog.dart:18` | `class_move.failed_dialog.confirm_button` / `class_move.failed_dialog.close_button` | 294/296 |

### Перенос урока, legacy-диалог — `features/classes_action/presentation/widgets/dialogs/class_reschedule_dialog/class_reschedule_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Дата | `.../widgets/class_reschedule_body/widgets/class_reschedule_date.dart:43` | `reschedule.date_selector` | 119 |
| 2 | Время (dropdown) | `.../widgets/class_reschedule_body/widgets/class_reschedule_time.dart:28` | `reschedule.time_selector` | 120 |
| 3 | **Пункт времени** | `.../class_reschedule_time.dart:28` | **`reschedule.time_option.$time`** (ключ слота HH:mm) | — |
| 4 | **«Back»** | `.../widgets/class_reschedule_body/class_reschedule_body.dart:105` | **`reschedule.back_button`** | — |
| 5 | «Reschedule» | `.../class_reschedule_body.dart:115` | `reschedule.confirm_button` | 125 |

### Урок перенесён — `features/classes_action/presentation/widgets/class_reschedule_success_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Go to schedule»** | `:69` | **`reschedule_success.go_to_schedule_button`** | — |
| 2 | **Закрыть** | `:82` | **`reschedule_success.close_button`** | — |

### Выбор слота, legacy — `presentation/page/class_creation/slot_select/slot_select_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Слот времени (SlotWidget) | `presentation/page/class_creation/slot_select/slot_select_page_content.dart:201` → `presentation/widgets/slot_widget.dart:54` | `booking.time_slot_item.${slot.startTime}` | 120 |
| 2 | Подтвердить бронь (FAB "teacher_confirm_class") | `.../slot_select_page_content.dart:142` | `booking.confirm_button` | 125 |
| 3 | Повторить загрузку | `.../slot_select_page_content.dart:213` | `booking.retry_button` | 290 |
| 4 | Диалоги резерва: «Close» | `.../slot_select_page_content.dart:34,59` | `booking.reserve_error_dialog.close_button`, `booking.reserve_fail_dialog.close_button` | 296 |
| 5 | Изменение подписки: «No» / «Yes» | `.../slot_select_page_content.dart:97,107` | `booking.subscription_changes_dialog.cancel_button` / `booking.subscription_changes_dialog.confirm_button` | 295/294 |

### Выбор учителя, legacy — `presentation/page/class_creation/teacher_select/teacher_select_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Выбор ученика (dropdown) + пункты | `presentation/widgets/teacher_search_options.dart:44` | `booking.student_selector`, **`booking.student_option.${value.id}`** | 117 |
| 2 | «Repeat weekly» (переключатель) | `presentation/widgets/teacher_search_options.dart:73` | `weekly_booking.enabled_switch` | 132 |
| 3 | **«Book by time» (переключатель)** | `presentation/widgets/teacher_search_options.dart:94` | **`booking.book_by_time_switch`** | — |
| 4 | **Выбор времени (пикер)** | `presentation/widgets/teacher_search_options.dart:134` | **`booking.time_selector`** | — |
| 5 | Тип учителя (dropdown) + пункты | `presentation/page/class_creation/teacher_select/teacher_select_page_content.dart:105` | `booking.lesson_type_selector`→ использован **`booking.teacher_level_selector`**, **`booking.teacher_level_option.${value.name}`** | — |
| 6 | Повторить загрузку | `.../teacher_select_page_content.dart:170` | `booking.retry_button` | 290 |
| 7 | «Book» (FAB, профиль учителя) | `presentation/page/class_creation/teacher_overview_page.dart:42` | `teacher.book_button` | 144 |

### Урок забронирован — `presentation/page/class_creation/class_created_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Go to schedule»** | `:65` | **`booking_success.go_to_schedule_button`** | — |
| 2 | **«Book for another child»** | `:~85` | **`booking_success.book_another_child_button`** | — |
| 3 | **«Add to calendar»** | `:197` | **`booking_success.add_to_calendar_button`** | — |
| 4 | **«Got it» (ошибка)** | `:54` | **`booking_success.got_it_button`** | — |
| 5 | **Синхронизация с Google Calendar** | `features/calendar_sync/presentation/widgets/google_calendar_sync_button.dart:20` | **`calendar_sync.google_sync_button`** | — |

### Реферальный экран после брони — `presentation/page/class_creation/class_created_referral_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Закрыть** | `.../class_created_referral_page_content.dart:26` | **`booking_referral.close_button`** | — |
| 2 | **Копировать ссылку** | `:343` | **`booking_referral.copy_link_button`** | — |
| 3 | **Поделиться** | `:370` | **`booking_referral.share_button`** | — |

### Запрос слота (Ask for slot) — `features/ask_slots/presentation/widgets/ask_for_slot_screen.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Weekly» / «One-time» (NovakidTabBar `semanticsId` + `tabSemanticsIds`)** | `.../ask_for_slot_mode_segment.dart:48` | **`ask_slot.mode_selector`**, **`ask_slot.weekly_tab`**, **`ask_slot.one_time_tab`** | — |
| 2 | **Поле даты (сброс)** | `.../ask_for_slot_date_field.dart:18` | **`ask_slot.date_selector`** | — |
| 3 | **Календарь (контейнер)** | `.../ask_for_slot_calendar_panel.dart:64` | **`ask_slot.calendar`** | — |
| 4 | **Слот времени** | `.../ask_for_slot_time_chips.dart:31` | **`ask_slot.time_slot_item.${slot.startTime.toIso8601String()}`** | — |
| 5 | **«Send request»** | `.../ask_for_slot_send_bar.dart:73` | **`ask_slot.send_request_button`** | — |
| 6 | **«Got it» (шторка)** | `.../ask_for_slot_success_bottom_sheet.dart:81` | **`ask_slot.success_sheet.got_it_button`** | — |

### Синхронизация календаря — `features/calendar_sync/presentation/calendar_sync_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Connect Google»** | `.../widgets/calendar_disconnected_content.dart:65` | **`calendar_sync.connect_google_button`** | — |
| 2 | **«Add all lessons»** | `.../widgets/calendar_disconnected_content.dart:143` | **`calendar_sync.add_all_lessons_button`** | — |
| 3 | **«Add single lesson»** | `.../widgets/calendar_sync_single_lesson_add_to_calendar.dart:45` | **`calendar_sync.add_single_lesson_button`** | — |
| 4 | **«Disconnect»** | `.../widgets/calendar_disconnect_button.dart:21` | **`calendar_sync.disconnect_button`** | — |
| 5 | Диалог ошибки: «Retry» / закрыть | `.../widgets/calendar_sync_error_dialog.dart:24` | `calendar_sync.error_dialog.confirm_button` / `calendar_sync.error_dialog.close_button` | 294/296 |

#### Подтверждение отключения — `features/calendar_sync/presentation/calendar_disconnect_confirm_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Закрыть** | `:40` | **`calendar_disconnect.close_button`** | — |
| 2 | **«Disconnect»** | `:82` | **`calendar_disconnect.confirm_button`** | — |
| 3 | **«Cancel»** | `:107` | **`calendar_disconnect.cancel_button`** | — |

#### Успешная синхронизация — `features/calendar_sync/presentation/calendar_sync_success.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Закрыть** | `:30` | **`calendar_sync_success.close_button`** | — |
| 2 | **«OK»** | `:87` | **`calendar_sync_success.done_button`** | — |

### Групповое расписание — `features/group_schedule/presentation/widgets/warning_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Основная кнопка | `:17` | `group_schedule.warning_dialog.confirm_button` | 294 |
| 2 | Закрыть (крестик) | `:91` | `group_schedule.warning_dialog.close_button` | 296 |

### Класс (урок) — `presentation/page/classroom/presentation/classroom.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Help»** | `.../widgets/tablet.dart:125`, `.../widgets/video/widgets/controllers.dart:25` | **`classroom.help_button`** | — |
| 2 | **«Chat»** | `tablet.dart:140`, `controllers.dart:32` | **`classroom.chat_button`** | — |
| 3 | **Микрофон вкл./выкл. (mute / unmute)** | `tablet.dart:149`, `controllers.dart:~41` | **`classroom.mute_button`** | — |
| 4 | **Завершить звонок (hang up)** | `tablet.dart:108,166`, `controllers.dart:~52` | **`classroom.hang_up_button`** | — |
| 5 | **Выйти из игры (перед уроком)** | `tablet.dart:93` | **`classroom.exit_game_button`** | — |
| 6 | **Эмодзи** | `.../widgets/emoji/emoji_button.dart:66` | **`classroom.emoji_button`** | — |
| 7 | **Реакция-эмодзи** | `.../emoji/emoji_reactions_panel.dart:33,53` | **`classroom.emoji_reaction.<asset_name>`** | — |
| 8 | **GIF** | `.../emoji/emoji_animated_panel.dart:37` | **`classroom.emoji_gif.${gif.key}`** | — |
| 9 | **Закрыть панель эмодзи** | `.../emoji/emoji_panel.dart:56,77` | **`classroom.emoji_panel.close_button`** | — |
| 10 | **Виртуальный фон** | `.../virtual_background/virtual_background_button.dart:115` | **`classroom.virtual_background_button`** | — |
| 11 | **Фон (элемент)** | `.../virtual_background/virtual_background_panel_body.dart:107` | **`classroom.virtual_background_item.<asset_name\|none>`** | — |
| 12 | **Закрыть панель фона / подсказку / тап вне панели** | `.../virtual_background_panel_body.dart:74`, `.../virtual_background_hint.dart:49`, `.../virtual_background_panel.dart:92` | **`classroom.virtual_background_panel.close_button`**, **`classroom.virtual_background_hint.close_button`**, **`classroom.virtual_background_panel.outside_area`** | — |
| 13 | **Аудиовыход (всплывающее меню) + пункты** | `.../video/widgets/audio_output.dart:20,47` | **`classroom.audio_output_selector`**, **`classroom.audio_output_option.${e.deviceId}`** | — |
| 14 | **Двойная громкость (dual volume): закрыть, слайдеры** | `.../dual_volume/classroom_dual_volume_manual_host.dart:175,185,196` | **`classroom.dual_volume.close_button`**, **`classroom.dual_volume.teacher_slider`**, **`classroom.dual_volume.lesson_slider`** | — |
| 15 | **«Back» на экране загрузки** | `.../widgets/loading_overlay.dart:18` | **`classroom.loading.back_button`** | — |
| 16 | **Зал ожидания (waiting room): «Join» (активная и неактивная)** | `.../waiting_room/join_button.dart:87,97` | **`classroom.waiting_room.join_button`** | — |
| 17 | **Зал ожидания: ждать учителя / играть** | `.../widgets/waiting_room.dart:142,197` | **`classroom.waiting_room.wait_for_teacher_button`**, **`classroom.waiting_room.play_games_button`** | — |
| 18 | **Зал ожидания: аудиоустройство** | `.../waiting_room/device_dropdown.dart:34` | **`classroom.waiting_room.audio_device_selector`** | — |
| 19 | **«Please wait»: закрыть** | `.../waiting_room/please_wait_overlay_content.dart:55` | **`classroom.waiting_room.please_wait.close_button`** | — |

#### Диалоги класса
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Выход: «Stay» / «Leave»** | `.../dialogs/classroom_close_dialog.dart:12` | **`classroom.leave_dialog.stay_button`** / **`classroom.leave_dialog.leave_button`** | — |
| 2 | **Нет связи: «Exit» / «Reconnect»** | `.../dialogs/classroom_connection_error_dialog.dart:12` | **`classroom.connection_error_dialog.exit_button`** / **`classroom.connection_error_dialog.reconnect_button`** | — |
| 3 | **Открыт на другом устройстве** | `.../dialogs/classroom_opened_on_another_device_dialog.dart:13` | **`classroom.another_device_dialog.back_to_class_button`** / **`classroom.another_device_dialog.back_to_dashboard_button`** | — |

### Прочее
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Тип учителя Standard / Premium (регистрация)** | `presentation/widgets/teacher_type_selector.dart:51,71` | **`teacher_type_selector.standard_option`** / **`teacher_type_selector.premium_option`** | — |
| 2 | **Слот (SlotWidget): необязательный `semanticsId`, запасной вариант** | `presentation/widgets/slot_widget.dart:54` | **`slot.time_slot_item`** (запасной, без ключа; все места вызова передают `booking.time_slot_item.<startTime>`, `teacher.time_slot_item.<startTime>` и т.п.) | — |

### Примечания
- Карточки учителя названы `teachers.teacher_card.<teacherId>`. Кнопки внутри карточки: `teacher.profile_button.<id>`, `teacher.book_button.<id>`, `teacher.avatar_button.<id>`, `teacher.gift_button.<id>`. ID задачи 124 `booking.teacher_item` не использован.
- В `TeacherCard` добавлен необязательный `semanticsId` для переопределения id карточки. `FavoriteTeachersScreen` его не передаёт, поэтому получает значение по умолчанию.
- Кнопка FILTER на экране выбора учителя теперь `booking.filters_button`, а не XPath `ImageView[2]`.
- Одинаковые `lesson.join_button`, `lesson.reschedule_button`, `lesson.cancel_button` стоят и на загрузочных (disabled) кнопках, и на рабочих. Одновременно видна только одна версия.
- Дни внутри `TableCalendar` (фильтры и ask-slot) нельзя разметить без форка пакета. Размечен только контейнер календаря.
- Ключи без серверного id: вариант в диалоге выбора (`$value` 0/1), пункты времени в legacy-переносе (строка HH:mm — ключ слота), реакции emoji и фоны (имя ассета), цифры parents gate.
- Повторить загрузку: использован параметр `RefreshErrorWidget.semanticsId`.
- Задачи без отдельного нативного UI: 96–101 (метки), 104 (`lesson.details_button`: открытие деталей идёт тапом по карточке урока в расписании, `schedule.lesson_card.<class.id>`), 107, 108, 109, 111, 112, 114 (поле ввода), 118 (`booking.lesson_type_selector`: в legacy есть только «тип учителя», id `booking.teacher_level_selector`), 121, 123, 126, 127, 133–135 (weekly_booking: отдельного экрана нет, есть только переключатель repeat weekly).
- `features/book_class`, `presentation/page/feedback`, `common/presentation/widgets/week_schedule`, `time_zone_info.dart`, `class_details.dart`, `date_title.dart`: интерактивных элементов нет.
- Для ShareSocialMediaProgram вместо одного `class_details_share` использованы два префикса, `class_details_share.highlight` и `class_details_share.screenshot`. Оба баннера могут одновременно стоять на одном экране деталей урока, и с общим префиксом id совпали бы.

## Подписка и оплата

Пути относительно `packages/shared/lib`. Строка — строка `SemanticsId(` / `id:` после правок.

### Управление подпиской (Stripe) — `features/membership/subscription_management/presentation/subscription_management_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Карточка подписки (контейнер, по каждой подписке студента)** | `features/membership/subscription_management/presentation/widgets/subscription_content_body.dart:48` | **`subscription.subscription_item.${stripeSubscriptionId}`** | — |
| 2 | «Buy subscription» (истёкшая подписка) | `features/membership/subscription_management/presentation/widgets/buttons/buy_subscription_button.dart:24` | `subscription.buy_button` | 150 |
| 3 | «Payment method & invoices» (платёжные данные) | `features/membership/subscription_management/presentation/widgets/pay_method_and_invoices.dart:37` | `subscription.billing_details_button` | 152 |
| 4 | «Reactivate» (отменённая подписка) | `features/membership/resume_reactivate/presentation/widget/reactivate_button_widget.dart:87` | `subscription.renew_button` | 169 |
| 5 | «Change plan» | `features/membership/update/presentation/update_plan_button.dart:44` | `subscription.change_plan_button` | 170 |
| 6 | **«Manage add-ons»** | `features/membership/update/presentation/update_addons_button.dart:56` | **`subscription.manage_addons_button`** | — |
| 7 | «Pause» | `features/membership/subscription_management/presentation/widgets/buttons/pause_subscription_button.dart:24` | `subscription.pause_button` | 171 |
| 8 | «Resume» («Renew» после паузы) | `features/membership/resume_reactivate/presentation/widget/resume_button_widget.dart:104` | `subscription.resume_button` | 172 |
| 9 | «Cancel subscription» | `features/membership/subscription_management/presentation/widgets/buttons/cancel_subscription_button.dart:44` | `subscription.cancel_button` | 173 |
| 10 | «Retry payment» (баннер неудачного автоплатежа) | `features/membership/subscription_management/presentation/widgets/banners/failed_auto_payment_banner.dart:96` | `payment.retry_button` | 255 |
| 11 | **Инфо (i) у кредитного баланса** | `features/membership/subscription_management/presentation/widgets/subscription_credit_info_button.dart:52` | **`subscription.credit_info_button`** | — |
| 12 | «Change plan» (UpdateSubscriptionButton, сейчас не используется) | `features/membership/update/presentation/update_subscription_button.dart:76` | `subscription.change_plan_button` | 170 |
| 13 | **«Manage add-ons» (UpdateSubscriptionButton, сейчас не используется)** | `features/membership/update/presentation/update_subscription_button.dart:95` | **`subscription.manage_addons_button`** | — |

#### Шторка «Update subscription» (UpdateSubscriptionBottomSheet, сейчас нигде не открывается)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Update add-ons»** | `features/membership/update/presentation/widgets/update_subscription_bottom_sheet.dart:68` | **`update_subscription_sheet.update_addons_button`** | — |

### Изменение подписки (WebView, нативная оболочка) — `features/membership/update/presentation/widgets/update_subscription_webview_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Close» (X поверх WebView)** | `features/membership/update/presentation/widgets/update_subscription_webview.dart:251` | **`update_subscription.close_button`** | — |
#### Диалог ошибки
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «OK» | `features/membership/update/presentation/widgets/update_subscription_webview.dart:277` | `update_subscription.dialog.confirm_button` | 294 |

### Платёжные данные (портал Stripe, нативная оболочка) — `features/membership/stripe_portal/subscription_billing_details_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Try again» (ошибка загрузки портала) | `features/membership/stripe_portal/presentation/widget/billing_error_widget.dart:73` | `billing.retry_button` | 290 |
| 2 | **«Close» (ошибка загрузки портала)** | `features/membership/stripe_portal/presentation/widget/billing_error_widget.dart:83` | **`billing.close_button`** | — |
#### Диалог ошибки
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «OK» | `features/membership/stripe_portal/presentation/widget/billing_portal_webview.dart:210` | `billing.dialog.confirm_button` | 294 |

### Отмена подписки (Stripe) — `features/membership/cancel_membership/presentation/cancel_membership_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Причина отмены (радиокнопка, по enum `CancelReason`) | `features/membership/cancel_membership/presentation/widgets/cancel_reason_option.dart:30` | `subscription_cancellation.reason_item.${reason.name}` | 177 |
| 2 | «Cancel subscription» (подтвердить) | `features/membership/cancel_membership/presentation/widgets/cancel_action_buttons.dart:28` | `subscription_cancellation.confirm_button` | 180 |
| 3 | «Continue» (оставить подписку) | `features/membership/cancel_membership/presentation/widgets/cancel_action_buttons.dart:48` | `subscription_cancellation.keep_button` | 181 |

### Пауза подписки (Stripe) — `features/membership/pause/presentation/pause_subscription_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Дата начала (выбор даты) | `features/membership/pause/presentation/widgets/pause_subscription_view.dart:112` | `subscription_pause.start_date_selector` | 174 |
| 2 | Дата окончания (выбор даты) | `features/membership/pause/presentation/widgets/pause_subscription_view.dart:139` | `subscription_pause.duration_selector` | 175 |
| 3 | «Pause» (открывает диалог подтверждения) | `features/membership/pause/presentation/widgets/pause_subscription_view.dart:163` | `subscription_pause.confirm_button` | 176 |

### Пауза подписки (legacy) — `features/subscription/pause_subscription/presentation/pause_subscription_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Дата начала | `features/subscription/pause_subscription/presentation/widgets/pause_subscription_view.dart:97` | `subscription_pause.start_date_selector` | 174 |
| 2 | Дата окончания | `features/subscription/pause_subscription/presentation/widgets/pause_subscription_view.dart:131` | `subscription_pause.duration_selector` | 175 |
| 3 | «Pause» | `features/subscription/pause_subscription/presentation/widgets/pause_subscription_view.dart:153` | `subscription_pause.confirm_button` | 176 |
| 4 | **Ссылка «написать в поддержку» (баннер об истечении)** | `features/subscription/pause_subscription/presentation/widgets/banners/expire_banner.dart:13` | **`subscription_pause.support_chat_link`** | — |

### Пауза групповой подписки — `features/subscription/pause_subscription/presentation/widgets/pause_group_subscription.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Дата начала | `features/subscription/pause_subscription/presentation/widgets/pause_group_subscription.dart:67` | `subscription_pause.start_date_selector` | 174 |
| 2 | «Pause» | `features/subscription/pause_subscription/presentation/widgets/pause_group_subscription.dart:82` | `subscription_pause.confirm_button` | 176 |

### Флоу паузы подписки (новый) — `features/subscription/pause_subscription_flow/presentation/pause_subscription_flow_entry_page.dart` (+ страницы выбора своих дат и подтверждения)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Back» (AppBar, общий scaffold всех шагов) | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_flow_scaffold.dart:30` | `navigation.back_button` | 43 |
| 2 | «Try again» (ошибка загрузки) | `features/subscription/pause_subscription_flow/presentation/pause_subscription_flow_page.dart:41` | `subscription_pause.retry_button` | 290 |
| 3 | **Карточка рекомендованного периода (7/14/… дней)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_recommended_step.dart:99` | **`subscription_pause.duration_option.$days`** | — |
| 4 | **«Choose custom dates»** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_recommended_step.dart:46` | **`subscription_pause.custom_dates_button`** | — |
| 5 | **«Pause for N days» (продолжить, рекомендованный шаг)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_recommended_step.dart:58` | **`subscription_pause.continue_button`** | — |
| 6 | Дата начала (свои даты) | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_custom_dates_step.dart:51` | `subscription_pause.start_date_selector` | 174 |
| 7 | Дата окончания (свои даты) | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_custom_dates_step.dart:66` | `subscription_pause.duration_selector` | 175 |
| 8 | **«Recommended period» (вернуться к пресетам)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_custom_dates_step.dart:81` | **`subscription_pause.recommended_period_button`** | — |
| 9 | **«Pause for N days» (продолжить, свои даты)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_custom_dates_step.dart:95` | **`subscription_pause.continue_button`** | — |
| 10 | **Альтернативный период (подтверждение)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_confirmation_step.dart:87` | **`subscription_pause.alternative_period_button`** | — |
| 11 | «Confirm pause» (Outlined или Elevated — один и тот же id) | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_confirmation_step.dart:142`, `:147` | `subscription_pause.confirm_button` | 176 |
| 12 | **«Go to schedule» (пауза недоступна)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_blocked_step.dart:139` | **`subscription_pause.go_to_schedule_button`** | — |
| 13 | **«Book lessons» (успех)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_success_step.dart:86` | **`subscription_pause.book_lessons_button`** | — |
| 14 | **«Not now» (успех)** | `features/subscription/pause_subscription_flow/presentation/widgets/pause_subscription_success_step.dart:97` | **`subscription_pause.not_now_button`** | — |

### Пауза / удержание в сезонном челлендже (лето / зима) — `features/subscription/summer_callenge/summer_challenge_pause_page.dart`, `features/subscription/winter_challenge/winter_challenge_pause_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Положительная кнопка («Agree» / «Stay»)** | `features/subscription/summer_callenge/widgets/season_challenge_action_buttons.dart:33` | **`season_challenge.positive_button`** | — |
| 2 | **Отрицательная кнопка (две ветки isPause, один id)** | `features/subscription/summer_callenge/widgets/season_challenge_action_buttons.dart:41`, `:49` | **`season_challenge.negative_button`** | — |

### Предложение удержания при отмене подписки — `features/subscription/unsubscribe/cancel_subscription_offer_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Pause instead»** | `features/subscription/unsubscribe/widgets/pause_subs_widget.dart:41` | **`subscription_cancellation.pause_instead_button`** | — |
| 2 | «Cancel subscription» (продолжить отмену) | `features/subscription/unsubscribe/widgets/retain_cancel_options_subs.dart:51` | `subscription_cancellation.continue_button` | 179 |

### Подтверждение отписки — `features/subscription/apply_unsubscribe/apply_unsubscribe_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Cancel» (продолжить отмену) | `features/subscription/apply_unsubscribe/apply_unsubscribe_page_content.dart:69` | `subscription_cancellation.continue_button` | 179 |
| 2 | «Continue» (оставить подписку) | `features/subscription/apply_unsubscribe/apply_unsubscribe_page_content.dart:96` | `subscription_cancellation.keep_button` | 181 |

### Отложенная подписка — `features/delayed_subscription/presenter/delayed_subscription.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Back» | `features/delayed_subscription/presenter/delayed_subscription_page_content.dart:32` | `navigation.back_button` | 43 |
| 2 | **«Buy in advance»** | `features/delayed_subscription/presenter/delayed_subscription_page_content.dart:89` | **`delayed_subscription.buy_in_advance_button`** | — |
| 3 | «Cancel subscription» (продолжить отмену) | `features/delayed_subscription/presenter/delayed_subscription_page_content.dart:103` | `subscription_cancellation.continue_button` | 179 |

### Причина отмены (legacy) — `features/subscription_reason_cancel/presenters/reason_cancel_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Причина (радиокнопка, по enum `ReasonCancel`) | `features/subscription_reason_cancel/presenters/widgets/cancel_option.dart:32` | `subscription_cancellation.reason_item.${reason.name}` | 177 |
| 2 | **«Technical issues» → написать в поддержку** | `features/subscription_reason_cancel/presenters/widgets/cancel.dart:73` | **`subscription_cancellation.technical_support_link`** | — |
| 3 | **«No availability» → забронировать уроки** | `...cancel.dart:103` | **`subscription_cancellation.book_lessons_link`** | — |
| 4 | **«Price» → скидка** | `...cancel.dart:137` | **`subscription_cancellation.discount_link`** | — |
| 5 | **«Cost» → скидка через поддержку** | `...cancel.dart:177` | **`subscription_cancellation.discount_support_link`** | — |
| 6 | **«Teacher quality» → поддержка** | `...cancel.dart:228` | **`subscription_cancellation.teacher_support_link`** | — |
| 7 | **Ссылка «отключить автопродление»** | `...cancel.dart:296` | **`subscription_cancellation.disable_auto_renewal_link`** | — |
| 8 | **«Vacation» → предложение паузы** | `...cancel.dart:330` | **`subscription_cancellation.pause_offer_link`** | — |
| 9 | «Cancel subscription» (красная) | `...cancel.dart:402` | `subscription_cancellation.confirm_button` | 180 |
| 10 | «Continue» (оставить) | `...cancel.dart:433` | `subscription_cancellation.keep_button` | 181 |

### Информация о балансе / Моя подписка — `features/balance_info_page/presentation/balance_info_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Try again» (ошибка загрузки) | `features/balance_info_page/presentation/balance_info_page_content.dart:132` | `balance_info.retry_button` | 290 |
| 2 | «Edit» / «Renew» (индивидуальная подписка) | `features/balance_info_page/presentation/widgets/subscriptions_info/widgets/active_subscription_info.dart:209` | `subscription.renew_button` | 169 |
| 3 | «Pause» | `...subscriptions_info/widgets/active_subscription_info.dart:222` | `subscription.pause_button` | 171 |
| 4 | «Resume» (ResumeSubscriptionActionButton, id по умолчанию) | `features/subscription/resume_subscription/presentation/resume_subscription_action_button.dart:26` | `subscription.resume_button` | 172 |
| 5 | «Cancel subscription» (Unsubscribe) | `features/subscription_change/widgets/subscription_summary/unsubscribe/presenter/unsubscribe.dart:69` | `subscription.cancel_button` | 173 |
| 6 | **«Start earlier»** | `...subscriptions_info/widgets/subscription_info/subscription_info.dart:158` | **`subscription.start_earlier_button`** | — |
| 7 | «Buy now» | `...subscriptions_info/widgets/subscription_info/subscription_info.dart:175` | `subscription.buy_button` | 150 |
| 8 | «Pause» (вкладка курса) | `...subscription_info/course_subscription_info.dart:110` | `subscription.pause_button` | 171 |
| 9 | «Resume» (вкладка курса) | `...subscription_info/course_subscription_info.dart:96` | `subscription.resume_button` | 172 |
| 10 | «Cancel» (вкладка курса) | `...subscription_info/course_subscription_info.dart:126` | `subscription.cancel_button` | 173 |
| 11 | «Pause» (группа WKA) | `...subscription_info/group_subscription_info.dart:94` | `subscription.pause_button` | 171 |
| 12 | «Resume» (группа WKA) | `...subscription_info/group_subscription_info.dart:103` | `subscription.resume_button` | 172 |
| 13 | «Cancel» (группа WKA) | `...subscription_info/group_subscription_info.dart:116` | `subscription.cancel_button` | 173 |
| 14 | **«Top up balance» (пакеты уроков)** | `features/balance_info_page/presentation/widgets/packages_info.dart:74` | **`balance_info.top_up_balance_button`** | — |
| 15 | «Add payment method» | `features/balance_info_page/presentation/widgets/default_payment_method/presenter/widgets/undefined.dart:40` | `payment.add_card_button` | 246 |
| 16 | **«Update card»** | `.../default_payment_method/presenter/widgets/card/card_method.dart:92` | **`payment.update_card_button`** | — |
| 17 | **«Try again» (метод оплаты)** | `.../default_payment_method/presenter/default_payment_method.dart:143` | **`payment.method_retry_button`** | — |
| 18 | «Buy now» (SubscriptionControl, сейчас не используется) | `.../subscription_info/widgets/subscription_control.dart:32` (параметр) | `subscription.buy_button` | 150 |
| 19 | «Edit» / «Renew» (SubscriptionControl, сейчас не используется) | `.../subscription_info/widgets/subscription_control.dart:35` | `subscription.change_plan_button` | 170 |

#### Удержание групповой подписки — `.../subscriptions_info/widgets/group_subscription_retention_screen.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Keep subscription» | `...group_subscription_retention_screen.dart:41` | `subscription_cancellation.keep_button` | 181 |
| 2 | «Cancel» (продолжить отмену) | `...group_subscription_retention_screen.dart:49` | `subscription_cancellation.continue_button` | 179 |

#### Причина отмены групповой подписки — `.../subscriptions_info/widgets/group_subscription_cancel_reason_screen.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Причина (радиокнопка, enum `SubscriptionCancellationReason`) | `.../subscriptions_info/widgets/cancel_subscription_reason.dart:29` | `subscription_cancellation.reason_item.${reason.name}` | 177 |
| 2 | «Cancel subscription» | `...group_subscription_cancel_reason_screen.dart:73` | `subscription_cancellation.confirm_button` | 180 |
| 3 | «Keep subscription» | `...group_subscription_cancel_reason_screen.dart:106` | `subscription_cancellation.keep_button` | 181 |

### Смена / покупка подписки (нативная) — `features/subscription_change/subscription_change_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Длительность (строка → экран периода)** | `features/subscription_change/widgets/subscription_parameters/widgets/parameters/subscription_period_parameter_widget.dart:41` | **`purchase.duration_selector`** | — |
| 2 | **Уроков в неделю (строка → экран)** | `.../parameters/lessons_per_week_parameter_widget.dart:37` | **`purchase.lessons_per_week_selector`** | — |
| 3 | **Категория преподавателя (строка → экран)** | `.../parameters/teacher_category_parameter_widget.dart:14` | **`purchase.teacher_category_selector`** | — |
| 4 | **Вкладка уровня преподавателя (standard / premium)** | `features/subscription_change/widgets/subscription_parameters/widgets/teacher_category.dart:127` | **`purchase.teacher_level_tab.${e.name}`** | — |
| 5 | «Monthly payment» | `.../monthly/choose_billing_type_widget.dart:46` | `purchase.monthly_payment_option` | 190 |
| 6 | «Pay in full» | `.../monthly/choose_billing_type_widget.dart:62` | `purchase.full_payment_option` | 191 |
| 7 | **«Use bonuses» (радиокнопка)** | `.../subscription_parameters/widgets/use_bonuses.dart:42` | **`purchase_summary.use_bonuses_option`** | — |
| 8 | **«Promo code» (радиокнопка, контейнер вокруг PromoCodeWidget)** | `.../discount/new_subscription_discount.dart:84` | **`purchase_summary.promo_code_option`** | — |
| 9 | **График платежей → «View details»** | `.../bullet_point_stepper/bullet_point_stepper.dart:50` | **`purchase_summary.payment_timeline_details_link`** | — |
| 10 | Раскрыть сводку следующего периода (ExpansionTile) | `features/subscription_change/widgets/subscription_buy/widgets/summary/next_period_subscription_summary_info.dart:43` | `purchase_summary.expand_button` | 230 |
| 11 | **Выбор метода оплаты (открывает шторку)** | `features/subscription_change/widgets/choose_payment_method/choose_payment_method_widget.dart:43` | **`payment.method_selector`** | — |
| 12 | «Confirm and Pay» (BuySubscriptionButton, id по умолчанию) | `common/presentation/widgets/buy_subscription_button/presenter/buy_subscription_button.dart:122` | `payment.pay_button` | 247 |
| 13 | «Confirm and Pay» (неактивная, состояние загрузки) | `common/presentation/widgets/buy_subscription_button/presenter/confirm_and_pay.dart:75` | `payment.pay_button` | 247 |
| 14 | **«Save and pay later»** | `common/presentation/widgets/buy_subscription_button/presenter/save_and_pay_later_button.dart:49` | **`payment.save_and_pay_later_button`** | — |
| 15 | «Cancel subscription» (Unsubscribe) | `features/subscription_change/widgets/subscription_summary/unsubscribe/presenter/unsubscribe.dart:69` | `subscription.cancel_button` | 173 |
| 16 | **«Try again» (ошибка)** | `features/subscription_change/widgets/subscription_states/subscription_failed_state_widget.dart:19` | **`subscription_change.retry_button`** | 290 (паттерн) |

#### Шторка «Choose payment method»
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Метод оплаты (по enum `TypePaymentMethod`) | `features/subscription_change/widgets/choose_payment_method/widgets/choose_payment_method_dialog.dart:47` | `payment.method_item.${method.name}` | 244 |

### Изменение периода подписки — `features/subscription/subscription_edit/subscription_period/presentation/subscription_period_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Вариант длительности (`3_months`, `6_months`, `12_months`, или `N_weeks`) | `features/subscription/subscription_edit/subscription_period/presentation/widgets/subscription_item.dart:40` | `purchase.duration_${durationKey}_option` | 186–188 |
| 2 | **«Save»** | `.../subscription_period/presentation/subscription_period_page_content.dart:79` | **`subscription_period.save_button`** | — |

### Изменение числа уроков в неделю — `features/subscription/subscription_edit/subscription_lessons_per_week/presentation/subscription_lessons_per_week.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **− (меньше уроков)** | `.../subscription_lessons_per_week/presentation/widget/edit_lessons_per_week.dart:39` | **`subscription_lessons_per_week.decrease_button`** | — |
| 2 | **+ (больше уроков)** | `.../widget/edit_lessons_per_week.dart:76` | **`subscription_lessons_per_week.increase_button`** | — |
| 3 | **«Save»** | `.../subscription_lessons_per_week_content.dart:132` | **`subscription_lessons_per_week.save_button`** | — |

### Изменение категории учителя — `features/subscription/subscription_edit/subscription_teacher_category/presentation/subscription_teacher_category_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Вкладка уровня (enum `TeacherLevel`)** | `.../widgets/edit_subscription_teacher_category.dart:126` | **`subscription_teacher_category.level_tab.${e.name}`** | — |
| 2 | **«Save»** | `.../subscription_teacher_category_page.dart:75` | **`subscription_teacher_category.save_button`** | — |

### Покупка подписки (выбор плана, общий виджет `BuySubscription`) — `common/presentation/widgets/buy_subscription/presenter/buy_subscription.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Карточка плана (контейнер; телефон — PageView) | `common/presentation/widgets/buy_subscription/presenter/widgets/list_of_subscriptions/widgets/phone_view.dart:78` | `purchase.plan_item.${billingPlan.billingPlan}` | 196 |
| 2 | Карточка плана (контейнер; планшет — тап выбирает план) | `.../list_of_subscriptions/widgets/tablet_view.dart:48` | `purchase.plan_item.${billingPlan.billingPlan}` | 196 |
| 3 | «Select» (Elevated у выбранного / Outlined у остальных) | `.../widgets/items/item_calculation.dart:208`, `:216` | `purchase.select_plan_button.${billingPlan.billingPlan}` | 205 |
| 4 | **− уроков в неделю** | `.../widgets/lessons_per_week/lessons_per_week.dart:35` | **`purchase.decrease_lessons_button`** | — |
| 5 | **+ уроков в неделю** | `.../widgets/lessons_per_week/lessons_per_week.dart:56` | **`purchase.increase_lessons_button`** | — |
| 6 | **«Start immediately» (радиокнопка)** | `.../widgets/start_date/start_date.dart:50` | **`purchase.start_immediately_option`** | — |
| 7 | **«Start from date» (радиокнопка, контейнер)** | `.../widgets/start_date/start_date.dart:63` | **`purchase.start_date_option`** | — |
| 8 | **Выбор даты старта (внутри радиокнопки)** | `.../widgets/start_date/widgets/choice_date.dart:26` | **`purchase.start_date_selector`** | — |

### Выбор способа оплаты — `features/select_payment_method/presenter/select_payment_method_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Метод оплаты (Stripe / MIR / P24 / Transfer, по enum `TypePaymentMethod`) | `features/select_payment_method/presenter/select_payment_method_page_content.dart:132`, `:157`, `:170`, `:185` | `payment.method_item.${element.name}` | 244 |

#### SelectPaymentMethodBottomSheet (виджет-селектор + шит)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Поле выбора метода (открывает шит)** | `features/select_payment_method/presenter/widgets/select_payment_method_bottom_sheet.dart:46` | **`payment.method_selector`** | — |
| 2 | Метод оплаты в шите (Stripe / MIR / P24 / NICEPAY / Transfer / PayPal) | `.../select_payment_method_sheet/select_payment_method_sheet.dart:31`, `:67`, `:95`, `:123`, `:151`, `:175` | `payment.method_item.${method.name}` | 244 |

### Оплата через Stripe checkout (нативная оболочка) — `features/checkout/stripe_checkout_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Back» (экран загрузки) | `features/checkout/widgets/loader.dart:9` | `navigation.back_button` | 43 |

### Виджеты подписки на главной (dashboard)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Resume subscription» (dashboard, передаётся параметром)** | `features/subscription/resume_subscription/presentation/resume_subscription_dashboard.dart:109` (параметр) → `resume_subscription_action_button.dart:26` | **`home.resume_subscription_button`** | — |
| 2 | **Закрыть баннер «подписка на паузе»** | `features/subscription/pause_subscription/presentation/widgets/subscription_paused_banner.dart:45` | **`subscription_paused_banner.close_button`** | — |
| 3 | Upsell-предложение: CTA («Choose» / «Switch to») — баннер на dashboard и блок на экране редактирования | `features/subscription/subscription_upsell/presentation/widgets/subscription_upsell_offer_card.dart:243` | `purchase_upsell.add_button` | 222 |
| 4 | Upsell-предложение: закрыть | `.../subscription_upsell_offer_card.dart:274` | `purchase_upsell.close_button` | 224 |

### Примечания
- Только текстовые подписи (не размечаются): 148 `subscription.title`, 149 `subscription.empty_state_message` (`no_active_subscription_card.dart`, кнопки там нет), 151 `subscription.billing_details_description`, 153 `billing.title`, 154 `billing.loading_message`, 164–168 (название плана, статус, баланс уроков, дата / сумма следующего платежа), 182 `purchase.title`, 183 `purchase.step_indicator`. Текстовое поле: 178 `subscription_cancellation.comment_input`.
- ID из задачи, для которых в приложении нет нативного UI: 192–194 (количество детей ±), 208 `purchase.continue_button`, 213 / 216 / 217 (экран add-ons — это WebView `UpdateSubscriptionRoute`), 223 `purchase_upsell.decline_button` (у upsell-карточки только CTA и закрытие), 229 `purchase_summary.edit_button`, 243 `purchase_summary.checkout_button` (в нативном флоу это сразу «Confirm and Pay» = `payment.pay_button`), 245 `payment.saved_card_item` (`card_method.dart` показывает карту, но она не нажимается; есть только «Update card»).
- Один и тот же ID на разных экранах — это ожидаемо: `subscription_cancellation.*` в пяти разных флоу отмены, `subscription_pause.*` в трёх флоу паузы, `subscription.*` на экранах «Управление подпиской» и «Информация о балансе». Внутри одного экрана ID уникальны, с двумя оговорками:
  - На экране «Управление подпиской» у одного студента может быть несколько подписок. Поэтому каждая подписка обёрнута в контейнер `subscription.subscription_item.${stripeSubscriptionId}`, и кнопки нужно искать внутри него.
  - На экране «Информация о балансе» вкладки лежат в `IndexedStack`, поэтому в semantics попадает только активная вкладка, и `subscription.pause_button` / `resume_button` / `cancel_button` не дублируются.
- Кнопки, у которых два взаимоисключающих варианта отрисовки с одним ID: `subscription_pause.confirm_button` (Outlined / Elevated), `purchase.select_plan_button.*` (Elevated / Outlined), `season_challenge.negative_button`.
- Повторяющиеся элементы с техническими ключами:
  - `payment.method_item.${TypePaymentMethod.name}`: значения `Stripe`, `MIR`, `P24`, `NICEPAY`, `Transfer`, `PayPal` — регистр как в enum.
  - `*.reason_item.${enum.name}`.
  - `purchase.plan_item.${BillingPlan.billingPlan}` и `purchase.select_plan_button.${BillingPlan.billingPlan}`: строковый id плана с сервера.
  - `purchase.duration_${N}_months_option` / `purchase.duration_${N}_weeks_option`: из длительности плана, совпадает с 186–188 для 3 / 6 / 12 месяцев.
  - `subscription_pause.duration_option.$days`: число дней пресета.
  - `*_tab.${TeacherLevel.name}`.
- Параметр `semanticsId` добавлен в `BuySubscriptionButton` (по умолчанию `payment.pay_button`; `SubscriptionControl` передаёт `subscription.buy_button`) и в `ResumeSubscriptionActionButton` (по умолчанию `subscription.resume_button`; dashboard передаёт `home.resume_subscription_button`).
- Вкладки (`Tab`) помечены через `Semantics(identifier:)` вокруг дочернего элемента вкладки: снаружи их не обернуть.
- `purchase_summary.expand_button` (ExpansionTile) — это merge-обёртка. В раскрытом состоянии строки сводки внутри сливаются в один узел с кнопкой.
- `purchase_summary.promo_code_option` — контейнер, потому что внутри поле промокода и кнопки. Сам `RadioListTile` при этом и так делает merge своего title.
- Код, который сейчас нигде не используется, но тоже помечен: `UpdateSubscriptionButton`, `UpdateSubscriptionBottomSheet`, `_CreditsInfoButton` (`subscription_credit_info_button.dart`), `SubscriptionControl`.

## Профиль, аккаунт, рефералка, учителя

Все пути относительно `packages/shared/lib`. Номера строк — после правок (строка с `id:` / `semanticsId:` / `identifier:`).

### Аккаунт (меню аккаунта) — `features/account/account_page/presentation/account_page_content.dart`
`SimpleAccountMenuItem` получил опциональный `semanticsId` (обёртка в `widgets/base/simple_account_menu_item.dart:44`), ID передаются с мест вызова.

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Personal information»** | `features/account/account_page/presentation/widgets/menu_items/personal_information_menu_item.dart:10` | **`account.personal_information_button`** | — |
| 2 | **«Calendar sync»** (под экспериментом) | `.../menu_items/calendar_sync_menu_item.dart:10` | **`account.calendar_sync_button`** | — |
| 3 | «Change password» | `.../menu_items/change_password_menu_item.dart:15` | `settings.change_password_button` | 271 |
| 4 | **«Balance history»** | `.../menu_items/balance_history_menu_item.dart:10` | **`account.balance_history_button`** | — |
| 5 | «Privacy policy» | `.../menu_items/privacy_policy_menu_item.dart:30` | `settings.privacy_link` | 276 |
| 6 | «Terms and conditions» | `.../menu_items/privacy_policy_menu_item.dart:42` | `settings.terms_link` | 277 |

### Личные данные — `presentation/page/parent_profile/personal_info/personal_info_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Замещающий учитель — «да» (чекбокс) | `presentation/page/parent_profile/personal_info/personal_info_page_content.dart:98` | `profile.substitute_teacher_yes_option` | 265 |
| 2 | Замещающий учитель — «нет» (чекбокс) | `...personal_info_page_content.dart:121` | `profile.substitute_teacher_no_option` | 266 |
| 3 | **«Remove account»** | `...personal_info_page_content.dart:139` | **`personal_info.remove_account_button`** | — |
| 4 | Повторить загрузку (экран ошибки) | `...personal_info_page_content.dart:171` | `personal_info.retry_button` | 290 |

#### Шторка удаления аккаунта — `features/remove_account/presentation/widgets/remove_account_bottom_sheet.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Delete forever» | `features/remove_account/presentation/widgets/remove_account_bottom_sheet.dart:93` | `remove_account.dialog.confirm_button` | 294 |
| 2 | «Cancel» | `...remove_account_bottom_sheet.dart:110` | `remove_account.dialog.cancel_button` | 295 |

### Профиль родителя (старый экран профиля) — `presentation/page/parent_profile/parent_profile_page_content.dart`
`ParentProfileItemList` получил опциональный `semanticsId` (обёртка в `presentation/page/parent_profile/list-items/parent_profile_item_list.dart:64`).

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Назад | `presentation/page/parent_profile/parent_profile_page_content.dart:41` | `navigation.back_button` | 43 |
| 2 | **«Personal information»** | `...parent_profile_page_content.dart:147` | **`parent_profile.personal_information_button`** | — |
| 3 | «Manage password» | `...parent_profile_page_content.dart:153` | `settings.change_password_button` | 271 |
| 4 | **«Edit children information»** | `...parent_profile_page_content.dart:165` | **`parent_profile.edit_children_button`** | — |
| 5 | **«Balance history»** | `...parent_profile_page_content.dart:171` | **`parent_profile.balance_history_button`** | — |
| 6 | **«Referral program»** | `...parent_profile_page_content.dart:177` | **`parent_profile.referral_program_button`** | — |
| 7 | **Ссылка на e-mail поддержки** | `...parent_profile_page_content.dart:189` | **`settings.support_email_link`** | — |
| 8 | «Log out» | `...parent_profile_page_content.dart:226` | `profile_menu.logout_button` | 61 |

### История баланса — `presentation/page/parent_profile/balance_history/balance_history_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Повторить загрузку | `presentation/page/parent_profile/balance_history/balance_history_page_content.dart:53` | `balance_history.retry_button` | 290 |

### Редактирование данных детей — `presentation/page/parent_profile/change_child_info/change_child_info_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Add new child» | `presentation/page/parent_profile/change_child_info/change_child_info_page_content.dart:29` | `profile_menu.add_student_button` | 55 |
| 2 | Повторить загрузку | `...change_child_info_page_content.dart:67` | `change_child_info.retry_button` | 290 |
| 3 | Карточка ученика (контейнер, внутри поле имени и выбор даты) | `presentation/page/parent_profile/change_child_info/item_student/item_student.dart:192` | `profile.student_item.<student id>` | 260 |
| 4 | Выбор даты рождения ученика | `.../item_student/item_student.dart:97` | `profile.student_birth_date_selector.<student id>` | 262 |

### Добавление ребёнка — `features/add_child_page/presentation/add_child_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Пол: девочка (радиокнопка)** | `features/add_child_page/presentation/add_child_page_content.dart:87` | **`add_child.gender_female_option`** | — |
| 2 | **Пол: мальчик (радиокнопка)** | `...add_child_page_content.dart:100` | **`add_child.gender_male_option`** | — |
| 3 | Дата рождения (`BirthDateSelect`) | `presentation/widgets/birthdate_select.dart:57` | `profile.student_birth_date_selector` | 262 |
| 4 | **«Add new child» (отправка)** | `...add_child_page_content.dart:131` | **`add_child.submit_button`** | — |

### Управление паролем (старый экран) — `presentation/page/parent_profile/manager_password/change_password/change_password_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Не помню пароль** | `presentation/page/parent_profile/manager_password/change_password/change_password_page_content.dart:51` | **`change_password.forgot_password_link`** | — |
| 2 | **Сгенерировать пароль** | `...change_password_page_content.dart:88` | **`change_password.generate_password_button`** | — |
| 3 | **Продолжить** | `...change_password_page_content.dart:114` | **`change_password.submit_button`** | — |

### Установка пароля (табы: новый пароль → способ → код) — `presentation/page/parent_profile/manager_password/set_password/set_password_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Продолжить (нижняя кнопка, общая для всех табов)** | `presentation/page/parent_profile/manager_password/set_password/set_password_page_content.dart:136` | **`set_password.continue_button`** | — |
| 2 | **Сгенерировать пароль** | `.../set_password/tabs/input_new_password/input_new_password_page.dart:64` | **`set_password.generate_password_button`** | — |
| 3 | **Отправить код на телефон (чекбокс)** | `.../set_password/tabs/choice_provider/choice_provider_page.dart:49` | **`set_password.phone_option`** | — |
| 4 | **Отправить код на e-mail (чекбокс)** | `.../set_password/tabs/choice_provider/choice_provider_page.dart:57` | **`set_password.email_option`** | — |
| 5 | **Отправить код повторно (с таймером)** | `.../set_password/tabs/input_code/input_code_page.dart:91` | **`set_password.resend_code_button`** | — |
| 6 | **Отправить код на другой контакт** | `.../set_password/tabs/input_code/input_code_page.dart:120` | **`set_password.change_contact_button`** | — |

### Пароль изменён — `presentation/page/parent_profile/manager_password/password_changed/password_changed_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **В аккаунт** | `presentation/page/parent_profile/manager_password/password_changed/password_changed_page_content.dart:29` | **`password_changed.to_account_button`** | — |

### Реферальная программа — `presentation/page/referral/referral_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Таб «Ссылка»** | `presentation/page/referral/referral_page_content.dart:56` | **`referral.link_tab`** | — |
| 2 | **Таб «Бонусы»** | `...referral_page_content.dart:62` | **`referral.bonuses_tab`** | — |
| 3 | Повторить загрузку (таб ссылки) | `...referral_page_content.dart:89` | `referral.retry_button` | 290 |
| 4 | Копировать реферальную ссылку | `...referral_page_content.dart:213` | `content.copy_referral_link_button` | 286 |
| 5 | **Поделиться ссылкой (таб ссылки)** | `...referral_page_content.dart:225` (обёртка — `:370`) | **`referral.share_link_button`** | — |
| 6 | **Повторить загрузку (таб бонусов)** | `...referral_page_content.dart:247` | **`referral.bonuses_retry_button`** | — |
| 7 | **Поделиться ссылкой (пустой таб бонусов)** | `...referral_page_content.dart:351` | **`referral.bonuses_share_link_button`** | — |

### Реферальный экран успеха (после оплаты) — `features/success_referral/success_referral_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Закрыть (крестик) | `features/success_referral/success_referral_page_content.dart:26` | `navigation.close_button` | 44 |
| 2 | Копировать ссылку (`ShareLinkField`, телефон и планшет) | `...success_referral_page_content.dart:250` | `content.copy_referral_link_button` | 286 |
| 3 | **Поделиться ссылкой** | `...success_referral_page_content.dart:271` | **`success_referral.share_link_button`** | — |

### Реферальный экран успеха после пробного — `features/success_referral/success_referral_post_trial_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Продолжить (payment_success_button)** | `features/success_referral/success_referral_post_trial_page.dart:127` | **`success_referral.continue_button`** | — |
| 2 | Копировать ссылку (`ShareLinkField`) | `features/success_referral/success_referral_page_content.dart:250` | `content.copy_referral_link_button` | 286 |
| 3 | **Поделиться ссылкой** | `...success_referral_post_trial_page.dart:197` | **`success_referral.share_link_button`** | — |

### Успех (универсальный экран успеха) — `features/success/success_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Кнопка внизу (текст из `SuccessPageData.buttonText`)** | `features/success/success_page.dart:39` | **`success.continue_button`** | — |

### Профиль учителя — `features/teacher/teacher_profile/teacher_profile_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Видео учителя (контейнер, кнопки плеера внутри)** | `features/teacher/common/presentation/teacher_video_player.dart:67`, `:77` | **`teacher.video_player`** | — (145, см. Примечания) |
| 2 | Избранное (сердечко) | `features/teacher/teacher_profile/teacher_profile_page.dart:146` (обёртка — `features/teacher/favorite_teachers/presentation/widgets/favorite_widget.dart:45`) | `teacher.favorite_button` | 142 |
| 3 | «Book lesson» | `...teacher_profile_page.dart:192` | `teacher.book_button` | 144 |

#### Диалог «Удалить из избранного» — `features/teacher/favorite_teachers/presentation/widgets/dialogs/confirm_remove_favorite_teacher_dialog.dart`
Через `DialogParams.semanticsIdPrefix`, ID строит `BaseDialog`.

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Remove» | `features/teacher/favorite_teachers/presentation/widgets/dialogs/confirm_remove_favorite_teacher_dialog.dart:21` | `remove_favorite_teacher.dialog.confirm_button` | 294 |
| 2 | «Cancel» | `...confirm_remove_favorite_teacher_dialog.dart:21` | `remove_favorite_teacher.dialog.cancel_button` | 295 |

### Детали учителя (старый экран учителя) — `features/teacher/teacher_details/presentation/teacher_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Назад | `features/teacher/teacher_details/presentation/teacher_page_content.dart:19` | `navigation.back_button` | 43 |
| 2 | **Видео учителя (контейнер)** | `features/teacher/common/presentation/teacher_video_player.dart:67`, `:77` | **`teacher.video_player`** | — |
| 3 | **Показать перевод / оригинал биографии** | `...teacher_page_content.dart:121` | **`teacher.translation_toggle`** | — |

### Избранные учителя — `features/teacher/favorite_teachers/presentation/widgets/favorite_teachers_screen.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Try again» (экран ошибки) | `features/teacher/favorite_teachers/presentation/widgets/favorite_teachers_screen.dart:87` | `favorite_teachers.retry_button` | 290 |
| 2 | Избранное в карточке учителя (`FavoriteWidget` внутри `TeacherCard`) | `features/teacher/favorite_teachers/presentation/widgets/favorite_widget.dart:45` | `teacher.favorite_button.<teacher id>` | 142 |

### Расписание учителя — `features/teacher/teacher_schedule/presentation/teacher_schedule_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Таб «Weekly» (нет в пробном)** | `features/teacher/teacher_schedule/presentation/teacher_schedule_page_content.dart:34` | **`teacher_schedule.weekly_tab`** | — |
| 2 | **Таб «One-time»** | `...teacher_schedule_page_content.dart:40` | **`teacher_schedule.one_time_tab`** | — |
| 3 | Слот времени | `features/teacher/teacher_schedule/presentation/widgets/teacher_schedule_slot_days_sliver.dart:143` | `teacher.time_slot_item.<slot startTime>` | 147 |
| 4 | Повторить загрузку слотов | `features/teacher/teacher_schedule/presentation/widgets/teacher_free_slots.dart:40` | `teacher_schedule.retry_button` | 290 |
| 5 | **«No suitable time» (запросить слот)** | `features/teacher/teacher_schedule/presentation/no_suitable_time_panel.dart:30` | **`teacher_schedule.no_suitable_time_button`** | — |

#### Нижняя панель выбранных слотов — `features/teacher/teacher_schedule/presentation/widgets/selected_slots_action_panel.dart`
Новый параметр `semanticsIdPrefix` (по умолчанию `teacher_schedule`).

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Заголовок «Выбрано N» — развернуть/свернуть (телефон / планшет)** | `features/teacher/teacher_schedule/presentation/widgets/selected_slots_action_panel.dart:109`, `:254` | **`teacher_schedule.selected_slots_expand_button`** | — |
| 2 | **«Choose» (телефон / планшет)** | `...selected_slots_action_panel.dart:169`, `:282` | **`teacher_schedule.selected_slots_continue_button`** | — |
| 3 | **Убрать выбранный слот (крестик на чипе)** | `...selected_slots_action_panel.dart:348` | **`teacher_schedule.selected_slot_remove_button.<slot startTime>`** | — |

### Подтверждение учителя — `features/teacher/teacher_schedule/presentation/teacher_confirmation_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Подтвердить бронирование (текст зависит от состояния; планшет / телефон)** | `features/teacher/teacher_schedule/presentation/teacher_confirmation_page.dart:202`, `:214` | **`teacher_confirmation.confirm_button`** | — (близко к 125) |

### Поиск учителя по имени — `features/search_teacher/presentation/search_by_name_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Закрыть | `features/search_teacher/presentation/search_by_name_page_content.dart:33` | `navigation.close_button` | 44 |
| 2 | Строка учителя в результатах | `features/search_teacher/presentation/widgets/teacher_list.dart:19` | `teachers.teacher_card.<teacher id>` | 139 |

### Выбор учителя (устаревший список, `FullTeachersList`) — `presentation/widgets/full_teachers_list.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Строка учителя | `presentation/widgets/full_teachers_list.dart:89` | `teachers.teacher_card.<teacher id>` | 139 |

#### Диалог «бронь недоступна в пробном периоде»
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Close» | `presentation/widgets/full_teachers_list.dart:105` | `teacher_select.dialog.close_button` | 296 |

### Диалог профилей учеников (выбор ученика) — `presentation/widgets/dialogs/student_profiles_dialog.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Карточка ученика (`HomeProfileCard`) | `features/profiles_page/presentation/widgets/profile_card.dart:61` | `student_selector.student_item` (дефолт; диалог выбора ученика передаёт `student_selector.student_item.<student id>`) | 85 |

### Регистрация (общие виджеты, используются в `features/sign_up/.../student_data_page.dart`)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Пол: девочка** | `presentation/widgets/gender_selector_material.dart:56` | **`registration.gender_female_option`** | — |
| 2 | **Пол: мальчик** | `presentation/widgets/gender_selector_material.dart:70` | **`registration.gender_male_option`** | — |
| 3 | **Дата рождения ученика** | `presentation/widgets/birthdate_material_select.dart:22` | **`registration.student_birth_date_selector`** | — |

### Ученик (legacy-экран ученика, роута нет) — `presentation/page/student/student_page_content.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Назад | `presentation/page/student/student_page_content.dart:26` | `navigation.back_button` | 43 |
| 2 | **Геймификация (Gamification)** | `...student_page_content.dart:69` | **`student.gamification_button`** | — |
| 3 | **Карточка урока** | `...student_page_content.dart:97` | **`student.lesson_card.<class id>`** | — |
| 4 | Повторить загрузку | `...student_page_content.dart:139` | `student.retry_button` | 290 |

### Лента активности: реферальное напоминание — `presentation/widgets/referral/referral_reminder.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Карточка напоминания (контейнер, кнопки «Share» / «Read more» внутри)** | `presentation/widgets/referral/referral_reminder.dart:46` | **`activity_stream.referral_reminder_card`** | — |

### Поделиться (сертификат / Nutty tale через `FacebookShare`)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Круглая кнопка «Share»** (`ShareSubFloatingButton`) | `presentation/widgets/share_button.dart:34` | **`content.share_button`** | — |

### Примечания
- `MenuButton` (`common/presentation/widgets/menu_item/menu_item.dart`) не размечен: его использует только `CustomDropdownButton` (`personal_info/items/dropdown_button.dart`), а тот нигде не создаётся (мёртвый код). То же с `GenderSelector` (`presentation/widgets/gender_selector.dart`). У `ParentProfileSwitchItemList` есть необязательный `semanticsId` для переключателя. `RoundAvatar` не интерактивен. В `features/support` и `features/share` кнопок нет.
- Экран `StudentPage` в роутере не зарегистрирован, но размечен на случай использования. `ParentProfilePage` зарегистрирован, но из UI на него ведёт только старый код; основной путь сейчас — экран Account.
- Ключи у повторяющихся элементов: учителя — `teacher.id`, ученики — `student.id`, уроки — `class.id`, слоты — `slot.startTime` (ISO-строка; серверного id у слота нет).
- `HomeProfileCard` в диалоге профилей учеников получает `student_selector.student_item.<student id>`.
- Табы (`referral.*_tab`, `teacher_schedule.*_tab`): `Tab(text:)` заменён на `Tab(child: Semantics(identifier:, child: Text(..., softWrap: false, overflow: fade)))`, отображение то же.
- `teacher.video_player` — контейнер. Кнопка Play внутри него (№ 145) — `teacher.play_video_button` (через `semanticsId` у `VideoUrlWidget`).
- № 267 `profile.substitute_teacher_help_button`: отдельной кнопки нет, пояснение — обычный текст внутри чекбокса «да».
- № 256–259, 261, 264 (поля и кнопки сохранения parent/student details): поля ввода не размечаются, кнопок «Save» на этих экранах нет; имя ученика сохраняется при потере фокуса поля.
- № 268–270, 272–275, 278 (язык / часовой пояс / уведомления / тест скорости / тест медиа / мышь / чат поддержки): в этом разделе UI не найден. Часовой пояс на экране личных данных — только текст.
- № 53, 54, 56–60, 62–64 (`profile_menu.*`): размечены в меню профиля, см. «Меню профиля (end drawer)» в разделе «Навигация, меню профиля, главная, расписание».
- № 136–138 (`teachers.search_input`, `filters_button`, `favorites_filter`): поиск — текстовое поле; отдельных фильтров на экране поиска нет (фильтры учителей — см. «Фильтры бронирования»).
- № 140, 141, 143, 146 — тексты/лейблы, не размечались.
- На экране установки пароля повторная отправка / смена контакта названы `set_password.*`, а не `otp.*` (22/24), чтобы не путать с OTP логина.

## Библиотека, достижения, челленджи, контент

Все пути относительно `packages/shared/lib`.

### Библиотека — `features/library/presentation/library_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Раздел библиотеки (заголовок ExpansionTile) | `features/library/presentation/widgets/library_section_tile.dart:25` | `content.library_category_item.${section.id}` | 279 |
| 2 | Карточка материала-ссылки | `features/library/presentation/widgets/library_link_card.dart:55` (обёртка в `library_material_card.dart:24`) | `content.library_content_item.link_${link.id}` | 280 |
| 3 | Карточка видео | `features/library/presentation/widgets/library_video_card.dart:43` (обёртка в `library_material_card.dart:24`) | `content.library_content_item.video_${video.id}` | 280 |
| 4 | «Play» на превью встроенного плеера (ссылка-видео) | `features/library/presentation/widgets/library_link_card.dart:35` → `presentation/widgets/video_widget.dart:144` | `content.open_content_button.link_${link.id}` | 281 |
| 5 | «Play» на превью встроенного плеера (видео) | `features/library/presentation/widgets/library_video_card.dart:34` → `presentation/widgets/video_widget.dart:144` | `content.open_content_button.video_${video.id}` | 281 |
| 6 | **Повторить загрузку** | `features/library/presentation/library_page.dart:45` | **`library.retry_button`** | 290 |

### Достижения (вкладки учеников) — `presentation/page/achievements/all_achievements_page.dart`, `achievements_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Карточка достижения (сетка) | `presentation/widgets/achievement_widget.dart:54` | `content.achievement_item.<type>_<id>` (`nuttyTale_<exerciseId>`, `certificate_<certId>`, `competency_<group>`) | 282 |
| 2 | **Вкладка ученика (TabBar)** | `presentation/page/achievements/all_achievements_page.dart:37` | **`achievements.student_tab.${student.id}`** | — |
| 3 | **Повторить загрузку списка учеников** | `presentation/page/achievements/all_achievements_page.dart:120` | **`achievements.students_retry_button`** | 290 |
| 4 | **Повторить загрузку достижений** | `presentation/page/achievements/achievements_page.dart:87` | **`achievements.retry_button`** | 290 |

### Программа (карта программы) — `presentation/page/achievements/program/program_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Назад | `presentation/page/achievements/program/program_page.dart:59` | `navigation.back_button` | 43 |
| 2 | **Заголовок уровня (раскрыть/свернуть)** | `presentation/page/achievements/program/student_program_map.dart:316` | **`program.level_item.${level.id}`** | — |
| 3 | **Заголовок юнита (раскрыть/свернуть)** | `presentation/page/achievements/program/student_program_map.dart:142` | **`program.unit_item.${unit.id}`** | — |
| 4 | **Видео перед уроком** | `presentation/page/achievements/program/student_program_map.dart:213` | **`program.pre_lesson_video_item.${video.id}`** | — |
| 5 | **Пройденный урок (открыть слайды), контейнер** | `presentation/page/achievements/program/student_stepper.dart:213` | **`program.lesson_item.${lesson.id}`** (`SemanticsId.container`) | — |
| 6 | **Сделать домашку (внутри последнего урока)** | `presentation/page/achievements/program/student_stepper.dart:344` | **`program.practice_button`** | — |
| 7 | **Повторить загрузку** | `presentation/page/achievements/program/student_program_map.dart:45` | **`program.retry_button`** | 290 |
| 8 | **Вкладка ученика, когда TabBar приходит из экрана завершения юнита** | `features/unit_completion/presentation/widgets/level-info/items/next_unit_widget.dart:29` | **`program.student_tab.${student.id}`** | — |

Вкладки, когда программа открыта из «Достижений», — это тот же TabBar с `achievements.student_tab.*`.

### Результаты оценки — `presentation/page/achievements/assessment/assessment_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Закрыть (крестик в AppBar, результаты) | `presentation/page/achievements/assessment/assessment_page_content.dart:88` | `navigation.close_button` | 44 |
| 2 | Закрыть (крестик в AppBar, «считаем результаты») | `presentation/page/achievements/assessment/assessment_page_content.dart:130` | `navigation.close_button` | 44 |
| 3 | **Вкладка «Освоено»** | `presentation/page/achievements/assessment/assessment_page_content.dart:48` | **`assessment.confirmed_tab`** | — |
| 4 | **Вкладка «Подтянуть»** | `presentation/page/achievements/assessment/assessment_page_content.dart:68` | **`assessment.to_improve_tab`** | — |
| 5 | **«Ещё N компетенций» (освоено)** | `presentation/page/achievements/assessment/widgets/confirmed_page.dart:135` → `presentation/widgets/assessment_column.dart:122` | **`assessment.confirmed_more_button`** | — |
| 6 | **«Ещё N компетенций» (подтянуть)** | `presentation/page/achievements/assessment/widgets/need_improve_page.dart:52` → `presentation/widgets/assessment_column.dart:122` | **`assessment.to_improve_more_button`** | — |
| 7 | **Поделиться** | `presentation/page/achievements/assessment/widgets/confirmed_page.dart:158` | **`assessment.share_button`** | — |

### Сертификат — `presentation/page/achievements/certificate/certificate_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Поделиться (FAB)** | `presentation/page/achievements/certificate/certificate_page_content.dart:106` | **`certificate.share_button`** | — |
| 2 | **Поделиться в Facebook** | `presentation/page/achievements/certificate/certificate_page_content.dart:139` | **`certificate.facebook_share_button`** | — |
| 3 | **Повторить загрузку** | `presentation/page/achievements/certificate/certificate_page_content.dart:80` | **`certificate.retry_button`** | 290 |

### Nutty tale — `presentation/page/achievements/nutty_tale/nutty_tale_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Поделиться (FAB)** | `presentation/page/achievements/nutty_tale/nutty_tale_page_content.dart:103` | **`nutty_tale.share_button`** | — |
| 2 | **Поделиться в Facebook** | `presentation/page/achievements/nutty_tale/nutty_tale_page_content.dart:116` | **`nutty_tale.facebook_share_button`** | — |

### Завершение уровня — `features/level_completion/presentation/level_completion_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Картинка сертификата → открыть PDF** | `features/level_completion/presentation/level_completion_page_content.dart:37` | **`level_completion.certificate_button`** | — |
| 2 | **Открыть PDF** | `features/level_completion/presentation/widgets/buttons.dart:13` | **`level_completion.open_pdf_button`** | — |

### Сертификат о завершении уровня — `features/level_completion_certificate/presentation/level_completion_certificarte_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Повторить загрузку** | `features/level_completion_certificate/presentation/level_completion_certificarte_page_content.dart:77` | **`level_completion_certificate.retry_button`** | 290 |

### Завершение юнита — `features/unit_completion/presentation/unit_completion_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Карточка компетенции (grammar / reading / speaking / vocabulary)** | `features/unit_completion/presentation/widgets/competencies/unit_completion_competencies_widget.dart:44,61,78,95` (обёртка в `.../competence_item_widget.dart:70`) | **`unit_completion.competence_item.${CompetenceType.name}`** | — |
| 2 | **Лайк страницы** | `features/unit_completion/presentation/widgets/feedback/widgets/feedback_button.dart:26` | **`unit_completion.feedback_positive_button`** | — |
| 3 | **Дизлайк страницы** | `features/unit_completion/presentation/widgets/feedback/widgets/feedback_button.dart:26` | **`unit_completion.feedback_negative_button`** | — |
| 4 | **Любимая игра** | `features/unit_completion/presentation/widgets/general-info/items/favorite_game_info_item.dart:15` (обёртка в `general_info_item.dart:43`) | **`unit_completion.favorite_game_item`** | — |
| 5 | **Любимый учитель** | `features/unit_completion/presentation/widgets/general-info/items/favorite_teacher_info_item.dart:15` | **`unit_completion.favorite_teacher_item`** | — |
| 6 | **Домашние задания** | `features/unit_completion/presentation/widgets/general-info/items/homework_info_item.dart:68` | **`unit_completion.homework_item`** | — |
| 7 | **Пройденные уроки → расписание** | `features/unit_completion/presentation/widgets/general-info/widgets/completed_lessons_widget.dart:15` | **`unit_completion.completed_lessons_item`** | — |
| 8 | **«Подробнее» о следующем юните** | `features/unit_completion/presentation/widgets/level-info/items/next_unit_widget.dart:86` | **`unit_completion.see_more_link`** | — |
| 9 | **Повторить загрузку** | `features/unit_completion/presentation/widgets/states/error_state.dart:13` | **`unit_completion.retry_button`** | 290 |
| 10 | **Поделиться (виджет `UnitCompletionShare`, сейчас нигде не используется)** | `features/unit_completion/presentation/widgets/share/share.dart:40` | **`unit_completion.share_button`** | — |

#### Диалоги экрана завершения юнита (классы есть, но нигде не показываются)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«OK» в `UnitCompletionCompetenciesDialog`** | `features/unit_completion/presentation/widgets/competencies/widgets/unit_completion_competencies_dialog.dart:51` (префикс) | **`unit_completion_competencies_dialog.confirm_button`** | 294 |
| 2 | **«OK» в `UnitCompletionShareDialog`** | `features/unit_completion/presentation/widgets/share/dialogs/unit_completion_share_dialog.dart:71` (префикс) | **`unit_completion_share_dialog.confirm_button`** | 294 |

### Сезонный челлендж (WebView) — `features/summer_challenge/presentation/season_challenge_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Повторить загрузку (до WebView)** | `features/summer_challenge/presentation/season_challenge_page.dart:91` | **`season_challenge.retry_button`** | 290 |

### Баннеры челленджей на главной (summer / winter / monthly)
Виджеты баннеров общие (`features/winter_challenge/presentation/widget/*`). Им добавлен параметр `semanticsPrefix` (по умолчанию `season_challenge_banner`), кнопки получают `<prefix>.action_button` и `<prefix>.faq_button`. В каждый момент показано одно состояние баннера, поэтому у кнопки действия один ID на все состояния (Join / Learn more / Go / Get my reward / Check my reward).

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Летний челлендж: кнопка баннера (все состояния)** | `features/summer_challenge/presentation/summer_challenge_banner.dart:82,119,158` → `features/winter_challenge/presentation/widget/season_challenge_banner_base.dart:51`, `.../preview_season_challenge_banner.dart:86` | **`summer_challenge_banner.action_button`** | — |
| 2 | **Летний челлендж: FAQ (i), только iOS** | `features/summer_challenge/presentation/widget/apple_sponsor_disclaimer.dart:37` | **`summer_challenge_banner.faq_button`** | — |
| 3 | **Зимний челлендж: кнопка баннера (все состояния)** | `features/winter_challenge/presentation/widget/winter_challenge_banner.dart:103,148,165` | **`winter_challenge_banner.action_button`** | — |
| 4 | **Зимний челлендж: FAQ (i), только iOS** | `features/winter_challenge/presentation/widget/apple_sponsor_disclaimer.dart:33` (через `season_challenge_banner_base.dart:64` / `preview_season_challenge_banner.dart:68`) | **`winter_challenge_banner.faq_button`** | — |
| 5 | **Ежемесячный челлендж: кнопка баннера (превью / в процессе)** | `features/monthly_challenge/presentation/monthly_challenge_banner.dart:102,148` | **`monthly_challenge_banner.action_button`** | — |
| 6 | **Ежемесячный челлендж: «Get my reward / Check my reward» (завершён)** | `features/monthly_challenge/presentation/monthly_challenge_banner.dart:224` | **`monthly_challenge_banner.action_button`** | — |
| 7 | **Ежемесячный челлендж: FAQ (i), только iOS** | `features/monthly_challenge/presentation/monthly_challenge_banner.dart:239` (+ превью / в процессе через общий префикс) | **`monthly_challenge_banner.faq_button`** | — |

#### Баннеры челленджей в подписке
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Летний челлендж: «Получить промокод»** | `features/summer_challenge/presentation/widget/subscription_banner/congratulations_banner_content.dart:34` | **`summer_challenge_subs_banner.get_promo_button`** | — |
| 2 | **Зимний челлендж: «Get my reward»** | `features/winter_challenge/winter_challenge_subs_banner.dart:79` | **`winter_challenge_subs_banner.get_reward_button`** | — |

### Упражнения на главной (виджет на главной) — `features/dashboard_exercises/presentation/widgets/dashboard_exercises_loaded.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Строка ученика с заданиями** | `features/dashboard_exercises/presentation/widgets/student_exercises.dart:45` | **`dashboard_exercises.student_item.${student.id}`** | — |

### Видео-хайлайт — `features/highlight_video_page/presentation/highlight_video_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Меню «Поделиться» в AppBar** | `features/highlight_video_page/presentation/highlight_video_page_content.dart:25` | **`highlight_video.share_menu_button`** | — |
| 2 | **Пункт меню «Скачать»** | `features/highlight_video_page/presentation/highlight_video_page_content.dart:32` | **`highlight_video.download_option`** | — |
| 3 | **Пункт меню «Поделиться»** | `features/highlight_video_page/presentation/highlight_video_page_content.dart:39` | **`highlight_video.share_option`** | — |
| 4 | **Повторить загрузку** | `features/highlight_video_page/presentation/highlight_video_page_content.dart:109` | **`highlight_video.retry_button`** | 290 |
| 5 | **Повторить воспроизведение (ошибка плеера)** | `presentation/widgets/video/widgets/video_error_widget.dart:41` | **`video_player.retry_button`** | 290 |

### Общий видеоплеер — `presentation/widgets/video_widget.dart` (`VideoUrlWidget`)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **«Play» на нативном превью (HLS)**, по умолчанию; новый параметр `semanticsId` | `presentation/widgets/video_widget.dart:144` | **`video_player.play_button`** | — |

Используется так же на Vimeo-странице (`features/vimeo_page/presentation/vimeo_video_page.dart:28`) и на экране видео (`features/embedding_video/presentation/widgets/video_page.dart:51`), с ID по умолчанию.

### Каталог курсов (нативная оболочка WebView) — `features/courses/presentation/course_catalog_page.dart`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Закрыть (крестик поверх WebView); ID по умолчанию из `buildCloseButton` | `features/courses/presentation/widgets/course_catalog_webview.dart:203` | `navigation.close_button` | 44 |
| 2 | **Повторить (ошибка WebView)** | `features/courses/presentation/widgets/course_catalog_webview.dart:209` | **`course_catalog.retry_button`** | 290 |

### Кабинет ученика (Kids area, WebView) — `features/student_area/presentation/student_area_page.dart`
Нативных кнопок на экране нет: выход идёт через системный back и parental gate.

#### Диалог «Нет доступа к камере/микрофону» (`ClassRoomPermissionDeniedDialog`, его показывают и classroom, и guards)
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Настройки** | `features/student_area/presentation/widgets/classroom_permission_denied_dialog.dart:22` (префикс) | **`classroom_permission_dialog.settings_button`** | 294 |
| 2 | **Закрыть** | `features/student_area/presentation/widgets/classroom_permission_denied_dialog.dart:22` (префикс) | **`classroom_permission_dialog.close_button`** | 296 |

### Оценка урока (`EvaluateLesson` / `EvaluateWidget`, экран завершённого урока) — `presentation/widgets/evaluate/*`
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Лайк** | `presentation/widgets/evaluate/evaluate_widget.dart:39` → `widgets/thumb_widget.dart:29` | **`lesson_evaluation.like_button`** | — |
| 2 | **Дизлайк** | `presentation/widgets/evaluate/evaluate_widget.dart:46` | **`lesson_evaluation.dislike_button`** | — |
| 3 | **Поделиться** | `presentation/widgets/evaluate/evaluate_widget.dart:52` (обёртка в `:84`) | **`lesson_evaluation.share_button`** | — |
| 4 | **ThumbWidget без явного ID (для `evaluate_form_dialog`)** | `presentation/widgets/evaluate/widgets/thumb_widget.dart:29` | **`evaluate.like_button` / `evaluate.dislike_button`** | — |

#### Диалог ошибки отправки оценки
| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Закрыть** | `presentation/widgets/evaluate/evaluate_lesson/evaluate_lesson.dart:151` | **`lesson_evaluation.dialog.close_button`** | 296 |

### Плашка действий под активностью (`EvaluateActivityTileWidget`) — `presentation/widgets/evaluate/evaluate_activity_tile_widget.dart`
Параметр `semanticsPrefix` (по умолчанию `activity_tile`), ID = `<prefix>.<name>_button` (`evaluate_activity_tile_widget.dart:270`). В таблице ниже ID с префиксом по умолчанию; места вызова передают свои префиксы: `home.academy_tile`, `home.congratulation_tile`, `home.activity_tile`, `home.level_completion_tile`, `home.unit_completion_tile`, `referral_reminder.tile`, `class_details.highlight_tile`, `class_details.screenshot_tile`.

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Домашка** | `evaluate_activity_tile_widget.dart:72` | **`activity_tile.homework_button`** | — |
| 2 | **Читать далее** | `evaluate_activity_tile_widget.dart:87` | **`activity_tile.read_more_button`** | — |
| 3 | **Подробнее** | `evaluate_activity_tile_widget.dart:98` | **`activity_tile.view_details_button`** | — |
| 4 | **Лайк** | `evaluate_activity_tile_widget.dart:110` | **`activity_tile.like_button`** | — |
| 5 | **Поделиться** | `evaluate_activity_tile_widget.dart:131` | **`activity_tile.share_button`** | — |
| 6 | **Скачать** | `evaluate_activity_tile_widget.dart:144` | **`activity_tile.download_button`** | — |
| 7 | **«Let's go»** | `evaluate_activity_tile_widget.dart:155` | **`activity_tile.lets_go_button`** | — |
| 8 | **Продолжить обучение** | `evaluate_activity_tile_widget.dart:166` | **`activity_tile.learning_button`** | — |

### Примечания
- Совпали ID из задачи: 43 (`navigation.back_button`, «Программа»), 44 (`navigation.close_button`, «Результаты оценки» и «Каталог курсов»), 279, 280, 281, 282, 290 (как `{screen}.retry_button`), 294 и 296 (как `<dialog>.confirm_button` / `.close_button` / `.dialog.close_button`).
- В этом разделе нет UI для задач 284 `content.speaking_practice_button` (speaking practice — SP-баннер на главной, см. «Главная (Dashboard)», и меню профиля) и 286 `content.copy_referral_link_button` (см. «Реферальная программа» в разделе «Профиль, аккаунт, рефералка, учителя»). Задача 84 `home.challenge_progress_value` — значение, а не кнопка, не размечается.
- Ключи элементов списков:
  - в библиотеке у ссылок и видео разные таблицы id, поэтому добавлены префиксы `link_` / `video_`;
  - у достижения-компетенции нет числового id: в ключ идёт строка группы (`Tuple2.item1`, assessmentGroup), в ней могут быть пробелы;
  - на экране завершения юнита элементы general-info, «пройденные уроки» и «see more» на экране единственные, поэтому ID у них ролевые, без ключа.
- `content.library_category_item.*` поставлен через `Semantics(identifier:)` на `title` ExpansionTile: обернуть заголовок снаружи нельзя, а `SemanticsId` вокруг всего тайла слил бы детей. QA: проверить, что id попадает на узел заголовка с действием tap.
- Заголовки уровня и юнита на экране программы (`ExpandablePanel`): `SemanticsId` стоит внутри `InkWell` пакета expandable. Узел с id несёт label и те же границы, а tap-action у родителя. Клик по координатам элемента работает.
- `certificate.facebook_share_button` / `nutty_tale.facebook_share_button`: когда Facebook не установлен, `FacebookShare` ничего не рисует, и может остаться пустой узел с этим id. Проверять видимость, а не только наличие.
- `UnitCompletionShare`, `UnitCompletionShareDialog` и `UnitCompletionCompetenciesDialog` нигде не используются: помечены заранее.

## Общие виджеты и диалоги

Пути указаны относительно `packages/shared/lib`. Разделы идут по общим виджетам, а не по экранам; в каждом указано, на каких экранах используется виджет (по grep вызовов).

Как работает вложение id: при вложенных `SemanticsId` (внешняя обёртка на месте вызова поверх id внутри виджета) побеждает **внешний** id. `SemanticsConfiguration.absorb` берёт identifier дочернего узла, только если у родителя он пустой. Поэтому id по умолчанию внутри общих виджетов не конфликтуют с обёртками на месте вызова.

---

### 1. API для мест вызова (параметры без id по умолчанию)

У каждого виджета появился `String? semanticsId`. Если параметр null, id не ставится; если задан, виджет оборачивается в `SemanticsId(id: ...)`.

| Виджет | Файл:строка | Параметр | Где используется (экраны) |
| --- | --- | --- | --- |
| `RoundIconButton` | `presentation/widgets/round_button.dart:13` | `semanticsId` | только в `DeprecatedRoundCornersDialog` (круглая кнопка закрытия) |
| `ContainerInkwell` | `presentation/widgets/container_inkwell.dart:9` | `semanticsId` | только внутри `RoundIconButton` |
| `LocalOutlineButton` | `presentation/widgets/outline_button.dart:9` | `semanticsId` | вызовов нет |
| `RoundedFlatButton` | `presentation/widgets/round_flat_button.dart` | `semanticsId` | register_success, success, change_child_info, change_password, password_changed, set_password, register_bottom_panel |
| `AccentButton`, `SecondaryButton` | `presentation/widgets/design_common.dart` | `semanticsId` | вызовов нет |
| `CustomCheckbox` | `presentation/widgets/checkbox/custom_checkbox.dart` | `semanticsId` | choice_provider (установка пароля), personal_info |
| `CircleButton` | `presentation/widgets/styled_widget/circle_button.dart` | `semanticsId` | buy_subscription/lessons_per_week (+/-) |
| `SelfGrayButton` | `styled_widget/gray_button.dart` | `semanticsId` | dashboard promocode |
| `SelfOutlinedButtonAttention` | `styled_widget/outlined_attention_button.dart` | `semanticsId` | retain_cancel_options_subs, classroom tablet |
| `SelfOutlinedButton` | `styled_widget/outlined_button.dart` | `semanticsId` | save_and_pay_later_button, balance_info (card_method, active_subscription_info, course/group_subscription_info, subscription_control) |
| `SelfOutlinedGrayButton` | `styled_widget/outlined_gray_button.dart` | `semanticsId` | add_2_calendar_button |
| `ElevatedButtonRed` | `styled_widget/red_button.dart` | `semanticsId` | subscription_reason_cancel/cancel.dart |
| `DialogButton` (устаревший) | `presentation/widgets/dialogs/deprecated_base_dialog.dart:98` | `semanticsId` | choice_teacher_dialog, evaluate_form_dialog |
| `DialogButton` (оценка приложения) | `presentation/widgets/dialogs/rate/dialog_button.dart` | `semanticsId` | rate_dialog |
| `RoundedCornersDialogButton` | `presentation/widgets/dialogs/deprecated_round_corners_dialog.dart` | `semanticsId` (если кнопка в диалоге одна и id не задан, ставится `<prefix>.confirm_button`) | item_student, set_password, parent_profile, personal_info, evaluate_lesson + диалоги ниже |
| `PasswordEditText` | `common/presentation/widgets/buttons/password_edit_text.dart:50` | `visibilityButtonSemanticsId` (показать/скрыть пароль) | restore_password/create_password (2 поля) |
| `TitleBorderTextField` | `presentation/widgets/title_border_textfield.dart:84` | `visibilityButtonSemanticsId` (IconButton показать/скрыть пароль) | sign_in_form (legacy), password_widet, add_child, restore_password, slot_retry, birthdate_select |

У `NovakidElevatedButton`, `NovakidOutlinedButton` и `OutlinedButtonWithIcon` изменений нет: места вызова оборачивают их сами.

---

### 2. BaseDialog: автоматические id для всех наследников

`common/presentation/widgets/dialogs/base_dialog.dart`, `core/dialog_action.dart`, `core/dialog_params.dart`

Новый API:
- `DialogParams.semanticsIdPrefix` (по умолчанию `'dialog'`).
- `DialogAction.semanticsId`: полный id, переопределяет всё остальное.
- `DialogAction.semanticsName`: «хвост» id. Фабрики задают его сами: `cancel()` → `cancel_button`, `close()` → `close_button`, `openSettings()` → `settings_button`. Все три фабрики также принимают `semanticsId`.
- Для остальных действий в `BaseDialog.actionSemanticsIds` первое primary-действие (если его нет, то первое destructive, если нет и его, то единственное) получает `confirm_button`, остальные `cancel_button`. ID внутри диалога не повторяются: крестик (если показан) занимает `<prefix>.close_button`, а при совпадении к выведенному ID добавляется суффикс `_2`, `_3`… (например, два `DialogAction.cancel()` → `cancel_button` и `cancel_button_2`). Сейчас ни один диалог в приложении под это правило не попадает.
- `buildActionButton(context, action, {String? semanticsId})`: подклассы, которые переопределяют `buildActions` и вызывают `buildActionButton` без id (например, `class_delete_one_time_dialog`), получают запасной id `dialog.<role>`.

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Primary / основное действие | `common/presentation/widgets/dialogs/base_dialog.dart:239` | `<prefix>.confirm_button` (по умолчанию `dialog.confirm_button`) | 294 |
| 2 | Вторичное действие / `DialogAction.cancel()` | `base_dialog.dart:239` | `<prefix>.cancel_button` | 295 |
| 3 | `DialogAction.close()` | `base_dialog.dart:239` | `<prefix>.close_button` | 296 |
| 4 | **`DialogAction.openSettings()`** | `base_dialog.dart:239` | **`<prefix>.settings_button`** | — |
| 5 | Крестик (`showCloseButton: true`) | `base_dialog.dart:90` | `<prefix>.close_button` | 296 |

Все наследники BaseDialog получают эти id автоматически (`dialog.*`, если не задан свой префикс). У многих префиксы заданы (auth.dialog, calendar_sync.error_dialog, reschedule.*, lesson_cancellation.* и т.д.).

### Наследники BaseDialog в общих виджетах

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Активация будущей подписки: «Cancel»** | `common/presentation/widgets/dialogs/activate_subscription_dialog.dart:26` | **`activate_subscription_dialog.cancel_button`** | — |
| 2 | **Активация будущей подписки: «Activate»** | `activate_subscription_dialog.dart:32` | **`activate_subscription_dialog.confirm_button`** | — |
| 3 | InformationDialog: «Close» | `common/presentation/widgets/dialogs/info_dialog.dart:20` | `dialog.close_button` | 296 |
| 4 | **Разрешение на доступ к хранилищу: «Settings»** | `common/presentation/widgets/storage_permission_dialog.dart:17` | **`storage_permission_dialog.settings_button`** | — |
| 5 | **Разрешение на доступ к хранилищу: «Close»** | `storage_permission_dialog.dart:18` | **`storage_permission_dialog.close_button`** | — |
| 6 | Отмена урока: «Back» (оставить урок) | `presentation/widgets/dialogs/class_delete_dialog/class_delete_dialog.dart:53` | `lesson_cancellation.keep_lesson_button` | 116 |
| 7 | Отмена урока: «Cancel lesson» | `class_delete_dialog.dart:65` | `lesson_cancellation.confirm_button` | 115 |
| 8 | **Отмена урока: чекбокс «все еженедельные»** | `presentation/widgets/dialogs/class_delete_dialog/widgets/class_delete_weekly.dart:25` | **`lesson_cancellation.weekly_checkbox`** | — |
| 9 | **Частичный резерв: «No»** | `presentation/widgets/dialogs/confirm_partial_reserve_dialog.dart:24` | **`partial_reserve_dialog.cancel_button`** | — |
| 10 | **Частичный резерв: «Yes»** | `confirm_partial_reserve_dialog.dart:31` | **`partial_reserve_dialog.confirm_button`** | — |
| 11 | **Закрытие приложения: «Close app»** | `presentation/widgets/dialogs/dialog_close_app.dart:22` | **`close_app_dialog.confirm_button`** | — |
| 12 | **Закрытие приложения: «Cancel»** | `dialog_close_app.dart:33` | **`close_app_dialog.cancel_button`** | — |
| 13 | **Выход из аккаунта: «Cancel»** | `presentation/widgets/dialogs/logout_dialog.dart:14` | **`logout_dialog.cancel_button`** | — |
| 14 | **Выход из аккаунта: «Log out»** | `logout_dialog.dart:15` | **`logout_dialog.confirm_button`** | — |
| 15 | **Другое устройство: «Got it»** | `presentation/widgets/dialogs/recommendation_use_other_device/recommendation_use_other_device.dart:41` | **`other_device_dialog.confirm_button`** | — |
| 16 | **Возобновление подписки: «Cancel»** | `presentation/widgets/dialogs/resume_subscription_dialog.dart:33` | **`resume_subscription_dialog.cancel_button`** | — |
| 17 | **Возобновление подписки: «Go ahead»** | `resume_subscription_dialog.dart:34` | **`resume_subscription_dialog.confirm_button`** | — |
| 18 | **Информация о смене подписки: «Proceed»** | `presentation/widgets/dialogs/subscription_change_info_dialog.dart:47` | **`subscription_change_dialog.confirm_button`** | — |
| 19 | **Обновление приложения: «Update»** | `presentation/widgets/dialogs/upgrade_dialog.dart:27` | **`upgrade_dialog.update_button`** | — |
| 20 | **Обновление приложения: «Skip»** (только при мягком обновлении) | `upgrade_dialog.dart:35` | **`upgrade_dialog.skip_button`** | — |
| 21 | Ошибка входа на урок: «Close» | `presentation/widgets/list_items/item_schedule/presentation/widgets/join_lesson/dialog/fail.dart:12` | `dialog.close_button` | 296 |

Где используются:
- Activate: balance_info / subscription_info.
- InformationDialog: schedule_bottom_sheet, class_actions, class_details actions, add_to_calendar_button, season_challenge, item_subscription_bonus.
- StoragePermission: dashboard item_activity.
- ClassDeleteDialog: class_actions, class_details actions.
- ConfirmPartialReserveDialog: вызовов нет.
- Logout: drawer log_out, parent_profile.
- CloseApp: upgrade_dialog (системная кнопка «назад» на Android).
- Upgrade: dashboard_page.
- ResumeSubscription: resume_button_widget, resume_subscription_action_button, teacher_schedule.
- SubscriptionChangeInfo: save_and_pay_later_button.
- OtherDevice: upcoming_class, classes_bloc, classroom_content, join_lesson.

---

### 3. Устаревшие диалоги

### DeprecatedBaseDialog — `presentation/widgets/dialogs/deprecated_base_dialog.dart`
Новый параметр `semanticsIdPrefix` (по умолчанию `'dialog'`).

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Крестик в шапке | `deprecated_base_dialog.dart:88` | `<prefix>.close_button` | 296 |

### DeprecatedRoundCornersDialog — `presentation/widgets/dialogs/deprecated_round_corners_dialog.dart`
У `show()` новый параметр `semanticsIdPrefix` (по умолчанию `'dialog'`).

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Круглый крестик под диалогом | `deprecated_round_corners_dialog.dart:132` | `<prefix>.close_button` | 296 |
| 2 | Единственная кнопка без id | `deprecated_round_corners_dialog.dart:64` | `<prefix>.confirm_button` | 294 |

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | **Выбор учителя: положительная кнопка** | `presentation/widgets/dialogs/choice_teacher_dialog.dart:37` | **`choice_teacher_dialog.confirm_button`** | — |
| 2 | **Выбор учителя: отрицательная кнопка** | `choice_teacher_dialog.dart:48` | **`choice_teacher_dialog.cancel_button`** | — |
| 3 | **Выбор учителя: крестик** | `choice_teacher_dialog.dart:21` (префикс) | **`choice_teacher_dialog.close_button`** | — |
| 4 | **Урок отменён: «Back to dashboard»** | `presentation/widgets/dialogs/class_canceled_proceed_dialog.dart:70` (префикс, одна кнопка) | **`class_canceled_dialog.confirm_button`** | — |
| 5 | **Изменение стоимости: «Agree»** | `presentation/widgets/dialogs/class_change_cost_dialog.dart:30` | **`class_change_cost_dialog.confirm_button`** | — |
| 6 | **Изменение стоимости: круглый крестик** | `class_change_cost_dialog.dart:30` | **`class_change_cost_dialog.close_button`** | — |
| 7 | **Нет слотов: «Choose another teacher»** | `presentation/widgets/dialogs/class_move_no_slots_dialog.dart:78,109` | **`no_slots_dialog.choose_teacher_button`** | — |
| 8 | **Нет слотов: «Cancel lesson»** | `class_move_no_slots_dialog.dart:100,116` | **`no_slots_dialog.cancel_lesson_button`** | — |
| 9 | **Нет слотов: круглый крестик** | `class_move_no_slots_dialog.dart:64` | **`no_slots_dialog.close_button`** | — |
| 10 | **Оценка урока: лайк** | `presentation/widgets/dialogs/evaluate_form_dialog.dart:66` | **`evaluate_dialog.like_button`** | — |
| 11 | **Оценка урока: дизлайк** | `evaluate_form_dialog.dart:81` | **`evaluate_dialog.dislike_button`** | — |
| 12 | **Оценка урока: «Send» (лайк)** | `evaluate_form_dialog.dart:110` | **`evaluate_dialog.send_button`** | — |
| 13 | **Оценка урока: «Send» (дизлайк)** | `evaluate_form_dialog.dart:194` | **`evaluate_dialog.send_button`** (взаимоисключающие состояния) | — |
| 14 | **Оценка урока: крестик** | `evaluate_form_dialog.dart:49` | **`evaluate_dialog.close_button`** | — |
| 15 | **Оценка приложения: звёзды рейтинга** (контейнер) | `presentation/widgets/dialogs/rate/rate_dialog.dart:59` | **`rate_dialog.rating_selector`** | — |
| 16 | **Оценка приложения: «Estimate» / «Send to developer»** | `rate_dialog.dart:136` | **`rate_dialog.submit_button`** | — |
| 17 | **Оценка приложения: «Do not show again»** | `rate_dialog.dart:159` | **`rate_dialog.deny_button`** | — |
| 18 | **Оценка приложения: круглый крестик** | `rate_dialog.dart:38` | **`rate_dialog.close_button`** | — |
| 19 | Выбор ученика: карточка ученика | `presentation/widgets/dialogs/student_profiles_dialog.dart:67` | `student_selector.student_item.${student.id}` | 85 |
| 20 | **Выбор ученика: круглый крестик** | `student_profiles_dialog.dart:20` | **`student_selector.close_button`** | — |
| 21 | **Детали пополнения: крестик** | `presentation/widgets/dialogs/top_up_monthly_details_dialog.dart:35` | **`top_up_details_dialog.close_button`** | — |
| 22 | **Отписка невозможна: крестик** | `presentation/widgets/dialogs/impossible_unsubscribe_dialog.dart:29` | **`impossible_unsubscribe_dialog.close_button`** | — |
| 23 | **Отписка невозможна: «OK»** | `impossible_unsubscribe_dialog.dart:70` | **`impossible_unsubscribe_dialog.confirm_button`** | — |
| 24 | **Ошибка загрузки приложения: «Try again»** | `presentation/widgets/dialogs/fail_loading_app_dialog.dart:21` | **`fail_loading_dialog.retry_button`** | — |

Где используются:
- ChoiceTeacher и Evaluate: evaluate_lesson.
- Rate и StudentProfiles: parent_content_page.
- TopUp: bullet_point_stepper (subscription_change).
- ImpossibleUnsubscribe: subscription_summary/unsubscribe.
- ClassCanceled / ChangeCost / NoSlots: вызовов `.show` не найдено (похоже на мёртвый код).

---

### 4. Шторки (bottom sheets) и оверлеи

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | ConfirmBottomSheet: «Agree» | `presentation/widgets/dialogs/confirm_bottom_sheet.dart:60` | `<semanticsIdPrefix>.confirm_button` (по умолчанию `dialog.`) | 294 |
| 2 | ConfirmBottomSheet: «Cancel» | `confirm_bottom_sheet.dart:71` | `<semanticsIdPrefix>.cancel_button` | 295 |
| 3 | **Шторка частичного резерва: «Yes»** | `presentation/widgets/dialogs/confirm_partial_reserve_bottom_sheet.dart:56` | **`partial_reserve_dialog.confirm_button`** | — |
| 4 | **Шторка частичного резерва: «No»** | `confirm_partial_reserve_bottom_sheet.dart:67` | **`partial_reserve_dialog.cancel_button`** | — |
| 5 | **Шторка выбора подписки: «Confirm»** | `presentation/widgets/dialogs/subscription_choice_bottom_sheet.dart:83` | **`subscription_choice_sheet.confirm_button`** | — |
| 6 | **Шторка выбора подписки: «Decline»** | `subscription_choice_bottom_sheet.dart:105` | **`subscription_choice_sheet.cancel_button`** | — |
| 7 | **Оверлей Practice app: крестик** | `presentation/widgets/dialogs/practce_app_dialog/practice_app_dialog_overlay.dart:77` | **`practice_app_dialog.close_button`** | — |
| 8 | **Оверлей Practice app: «Open»** | `practice_app_dialog_overlay.dart:137` | **`practice_app_dialog.open_button`** | — |

Где используются:
- ConfirmBottomSheet: class_add/reserve_teacher_slot_handler. Новый параметр `semanticsIdPrefix`; на месте вызова можно передать, например, `'booking.confirm_sheet'`.
- PartialReserveSheet и SubscriptionChoiceSheet: teacher_schedule_page_content.
- PracticeAppDialogOverlay: прямых вызовов не найдено.

---

### 5. Виджеты ошибок и повтора

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | RefreshErrorWidget (весь блок, тап = повтор) | `presentation/widgets/refresh_error_widget.dart:20` | `common.retry_button` (параметр `semanticsId`) | 290 |
| 2 | SmallRefreshErrorWidget | `refresh_error_widget.dart:86` | `common.retry_button` (параметр `semanticsId`) | 290 |
| 3 | WebViewErrorWidget: «Tap to refresh» | `common/presentation/widgets/web_view_error_widget.dart:38` | `common.retry_button` (параметр `semanticsId`) | 290 |

Где используются:
- RefreshErrorWidget (22 файла): class_details (состояние ошибки), highlight_video, level_completion_certificate, library, membership pause, диалоги trial_day/slot_pick, season_challenge, teacher_free_slots, unit_completion (error_state), achievements, all_achievements, certificate, student_program_map, slot_select, teacher_select, dashboard_activity_feed, balance_history, change_child_info, personal_info, referral (2), student_page.
- SmallRefreshErrorWidget: student_progress.
- WebViewErrorWidget: course_catalog_webview (там передан `course_catalog.retry_button`), subscription_management_page, subscription_management_webview.

Многие места вызова обёрнуты своими `{screen}.retry_button`; внешний id побеждает (см. начало раздела).

---

### 6. Нативная оболочка WebView

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Крестик поверх WebView (`PolicyWebViewMixin.buildCloseButton`) | `common/presentation/mixins/policy_web_view_mixin.dart:161` | `navigation.close_button` (параметр `semanticsId`) | 44 |

Где используется: course_catalog_webview, subscription_management_webview.

---

### 7. OTP: подтверждение кода (`PinConfirm`) — `presentation/widgets/confirm/pin_confirm.dart`

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | «Resend code» (SMS) | `presentation/widgets/confirm/pin_confirm.dart:114` | `otp.resend_button` | 22 |
| 2 | **«Resend code by email»** | `pin_confirm.dart:157` | **`otp.resend_email_button`** | — |

Где используется: прямых вызовов `PinConfirm(` не найдено.

---

### 8. Элемент расписания (`ItemSchedule`) и кнопка Join на главной

| # | Кнопка | Файл:строка | Идентификатор | № в задаче |
| --- | --- | --- | --- | --- |
| 1 | Меню «⋮» у урока (только на планшете) | `presentation/widgets/list_items/item_schedule/presentation/widgets/regular_item_schedule.dart:102` | `lesson.more_button.${classChild.id}` | 102 |
| 2 | Меню «⋮» у урока (состояние «можно войти») | `.../widgets/join_lesson_schedule.dart:118` | `lesson.more_button.${classChild.id}` | 102 |
| 3 | «Join» в карточке расписания | `.../widgets/join_lesson_schedule.dart:179` | `lesson.join_button.${classChild.id}` | 103 |
| 4 | JoinLessonButton (дашборд) | `.../widgets/join_lesson/widgets/content.dart:45` | `home.join_lesson_button` (параметр `JoinLessonButton.semanticsId`) | 78 |

Где используются:
- ItemSchedule: только Schedule → future → month_section. Сама карточка (тап открывает детали) обёрнута на месте вызова: `SemanticsId.container(id: 'schedule.lesson_card.${id}')` в `month_section.dart`.
- JoinLessonButton: dashboard upcoming_classes group_class / legacy_class (там тоже уже есть внешние обёртки, они побеждают).

---

### Примечания

- Идентификаторы во всех диалогах уникальны в пределах диалога. Одновременно показывается только один диалог, поэтому общие `dialog.*` между разными диалогами не конфликтуют. У наследников BaseDialog с правилом (primary → confirm, второе → cancel, фабрики → своё имя) коллизий нет.
- `evaluate_dialog.send_button` стоит на двух разных кнопках, но они взаимоисключающие (like / dislike), на экране одновременно не бывает двух.
- `DotsIndicator` (`presentation/widgets/page_view_dot_indicator.dart:62`): точки пейджера тапабельны, но технического ключа у них нет, только индекс страницы, а индекс в id запрещён. Не размечены. Используется только внутри своего файла (вызовов не найдено).
- `ClassCanceledProceedDialog`, `ClassChangeCostDialog`, `ClassMoveNoSlotsDialog`, `ConfirmPartialReserveDialog`, `PracticeAppDialogOverlay`, `PinConfirm`, `LocalOutlineButton`, `AccentButton`, `SecondaryButton`: вызовов не найдено (вероятно, мёртвый код). Id проставлены на случай использования.
- Виджеты в `common/presentation/widgets/loaders`, `inputs` (только текстовое поле), `show_custom_date_picker.dart`, `photo_counter.dart`, `animated_loading_data_switcher.dart`, `tablet_constrained_width.dart`, `dialog_widget.dart`, `common/presentation/app`, `common/presentation/web_view`, `presentation/widgets/loading`, `logo`, `shapes`, `container_with_left_stripe.dart`: тапабельных элементов нет.
- Тап по фону `DeprecatedRoundCornersDialog` (`screenTapCancelable`) — это барьер, а не кнопка. Не размечен.
- Из номеров задачи общие виджеты этого раздела покрывают 22, 44, 78, 85, 102, 103, 115, 116, 290, 294, 295, 296. Номер 18 (`login.password_visibility_button`) задаётся на месте вызова, см. «Вход по email/телефону».

