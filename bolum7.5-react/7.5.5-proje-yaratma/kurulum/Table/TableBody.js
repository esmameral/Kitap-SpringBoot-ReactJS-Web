import React from 'react';

class TableBody extends React.Component {
    render() {
        return (
            <tbody>
                <tr>
                    <th><img src={require('../../images/tablet.jpg')} alt="img-tablet" width="100" height="100" /></th>
                    <th>32GB Tablet Gümüş</th>
                    <th>702 TL</th>
                    <th><b>Teknik Özellikleri:</b>Depolama birimi:RAM 2GB, Dahili Hafıza: 32 GB, Ekran boyutu: 8 '',Dokunmatik ekran,  Hafıza: 2GB ,Batarya Pil performansı: 5100 mAh, Ekran boyutu: 8 '',Ekran boyutu: 8 '', Ekran çözünürlüğü 1280 x 800 Piksel, Platform: Android</th>
                </tr>
                <tr>
                    <th><img src={require('../../images/shoe.jpg')} alt="img-shoe" width="100" height="100" /></th>
                    <th>Erkek Ayakkabı</th>
                    <th>150 TL</th>
                    <th>Soğuk ve suya karşı dayanıklı, Kaymaz taban, Bağcıklı, Anatomik Kalıp, Dış Materyal : Su Geçirmez 1.Sınıf İthal Microfiber Malzeme İç Materyal : Soğuk Geçirmez 1.Kalite İthal Kürk</th>
                </tr>
                <tr>
                    <th><img src={require('../../images/watch.jpg')} alt="img-watch" width="100" height="100" /></th>
                    <th>Kadın Saat</th>
                    <th>200 TL</th>
                    <th>Cinsiyet: Kadın, Çalışma Tipi: Pilli (Quartz), Kordon Rengi: Gri, Kordon: Çelik, Su Geçirmezlik: 30 m</th>
                </tr>
                <tr>
                    <th><img src={require('../../images/chair.jpg')} alt="img-chair" width="100" height="100" /></th>
                    <th>Masa Sandalyesi</th>
                    <th>400 TL</th>
                    <th>Yumuşak dokulu döşeme. Kolay silinebilir yüzey. Sandalye Yükseklik 92cm / Genişlik 40cm· Ürün demonte olarak gönderilmektedir, kurulum alıcıya ait ve basittir. </th>
                </tr>
            </tbody>
        );
    }
}

export default TableBody;
