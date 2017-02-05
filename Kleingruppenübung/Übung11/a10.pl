blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(flattenalm).
blau(wiesenalm).
rot(isskogel).
schwarz(teufeltal).
start(sonnalm).
start(teufeltal).
endetIn(sonnalm, vorkogel).
endetIn(sonnalm, arbiskogel).
endetIn(vorkogel,isskogel).
endetIn(arbiskogel,flattenalm).
endetIn(flattenalm, wiesenalm).
endetIn(teufeltalm, wiesenalm).
endetIn(wiesenalm, tal).
endetIn(isskogel, tal).

%b:
%endetIn(X, wiesenalm). (2 Antworten)

%c:
gleicherStartpunkt(X, Y) :- start(X), start(Y).
gleicherStartpunkt(X, Y) :- endetIn(Z,X), endetIn(Z,Y).

%d
anfaengerGeignet(X) :- blau(X), endetIn(X, tal).
anfaengerGeignet(X) :- blau(X), endetIn(X,Y), anfaengerGeignet(Y).