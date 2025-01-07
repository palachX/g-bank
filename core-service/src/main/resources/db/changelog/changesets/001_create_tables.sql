create table accounts
(
    id      uuid    not null primary key,
    number  varchar not null unique,
    balance decimal not null default 0
);

create table clients
(
    id         uuid     not null primary key,
    name       varchar  not null,
    phone      char(11) not null unique,
    password   varchar  not null,
    account_id uuid     not null,
    constraint clients_accounts foreign key (account_id) references accounts (id)
);

create table cards
(
    id              uuid     not null primary key,
    number          char(16) not null,
    date_expiration date     not null,
    cvv             char(3)  not null,
    account_id      uuid     not null,
    constraint cards_unique unique (number, date_expiration),
    constraint cards_accounts foreign key (account_id) references accounts (id)
);

create table clients_cards
(
    client_id uuid not null,
    card_id   uuid not null,
    constraint clients_cards_unique unique (client_id, card_id),
    constraint clients_cards_clients foreign key (client_id) references clients (id),
    constraint clients_cards_cards foreign key (card_id) references cards (id)
);

create table transactions
(
    id      uuid    not null primary key,
    from_id uuid    not null,
    to_id   uuid    not null,
    amount  decimal not null,
    constraint transactions_cards_from foreign key (from_id) references cards (id),
    constraint transactions_cards_to foreign key (to_id) references cards (id)
);

create table cards_transactions
(
    card_id        uuid not null,
    transaction_id uuid not null,
    constraint cards_transactions_unique unique (card_id, transaction_id),
    constraint cards_transactions_cards foreign key (card_id) references cards (id),
    constraint cards_transactions_transactions foreign key (transaction_id) references transactions (id)
);
